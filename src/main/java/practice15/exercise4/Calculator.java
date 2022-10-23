package practice15.exercise4;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class Calculator extends JFrame {
    interface BinaryEvaluator {
        double evaluate(double a, double b);
    }

    enum Operation {
        Add("+", (a, b) -> a + b),
        Subtract("-", (a, b) -> a - b),
        Multiply("*", (a, b) -> a * b),
        Divide("/", (a, b) -> {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Делить на ноль нельзя!");
                return a;
            }
            return a / b;
        });

        private final String symbol;
        private final BinaryEvaluator evaluator;

        Operation(String symbol, BinaryEvaluator evaluator) {
            this.symbol = symbol;
            this.evaluator = evaluator;
        }

        public String getSymbol() {
            return symbol;
        }

        public BinaryEvaluator getEvaluator() {
            return evaluator;
        }
    }

    private Operation currentOperation = Operation.Add;
    private double accumulatedResult = 0;
    private boolean firstStep = true;

    private Calculator() {
        super("Simple calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 400);

        setLayout(new GridLayout(2, 1));

        var textDisplay = new JTextPane();
        add(textDisplay);

        var numberInputPanel = new NumberInputPanel(textDisplay::setText);
        add(numberInputPanel);

        var c = new GridBagConstraints();
        c.gridx = 3;
        c.gridy = 0;
        for (var operation : Operation.values()) {
            var operationButton = new JButton(operation.getSymbol());
            final var operationCopy = operation;
            operationButton.addActionListener(l -> {
                if (currentOperation != null) {
                    accumulatedResult = currentOperation.evaluator.evaluate(accumulatedResult, numberInputPanel.getValue());
                }
                numberInputPanel.reset();
                if (!firstStep)
                    textDisplay.setText("= " + accumulatedResult);
                firstStep = false;
                currentOperation = operationCopy;
            });
            numberInputPanel.add(operationButton, c);
            c.gridy++;
        }

        c.gridy--;
        c.gridx--;
        var equalsButton = new JButton("=");
        equalsButton.addActionListener(l -> {
            if (currentOperation != null) {
                accumulatedResult = currentOperation.evaluator.evaluate(accumulatedResult, numberInputPanel.getValue());
            }
            textDisplay.setText("= " + accumulatedResult);
            currentOperation = null;
        });
        numberInputPanel.add(equalsButton, c);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    private static class NumberInputPanel extends JPanel {
        private final Consumer<String> onNumberInput;

        private boolean isInteger = true;
        private String currentNumberInput = "0";

        public NumberInputPanel(Consumer<String> onNumberInput) {
            this.onNumberInput = onNumberInput;

            setLayout(new GridBagLayout());
            var c = new GridBagConstraints();
            c.insets = new Insets(10, 10, 10, 10);

            int currentDigit = 9;
            for (int y = 0; y < 4; y++) {
                for (int x = 2; x >= 0; x--) {
                    c.gridx = x;
                    c.gridy = y;

                    if (currentDigit == 0) {
                        c.gridx = 0;
                    }

                    var numberButton = new JButton(Integer.toString(currentDigit));
                    final var buttonDigit = currentDigit;
                    numberButton.addActionListener(l -> inputDigit(buttonDigit));
                    add(numberButton, c);

                    currentDigit--;
                    if (currentDigit < 0) {
                        break;
                    }
                }
            }

            c.gridx++;
            var fractionButton = new JButton(".");
            fractionButton.addActionListener(l -> startEnteringFractionPart());
            add(fractionButton, c);

            onNumberInput.accept("0");
        }

        public double getValue() {
            return Double.parseDouble(currentNumberInput);
        }

        public void reset() {
            isInteger = true;
            onNumberInput.accept(currentNumberInput = "0");
        }

        private void inputDigit(int digit) {
            currentNumberInput = currentNumberInput.equals("0")
                ? Integer.toString(digit)
                : currentNumberInput + digit;

            onNumberInput.accept(currentNumberInput);
        }

        private void startEnteringFractionPart() {
            if (isInteger) {
                isInteger = false;
                onNumberInput.accept(currentNumberInput += ".");
            }
        }
    }
}
