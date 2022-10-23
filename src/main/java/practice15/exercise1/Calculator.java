package practice15.exercise1;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    private Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setSize(200, 200);
        setLayout(new GridBagLayout());

        var c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);

        var leftOperandInput = new JSpinner();
        var rightOperandInput = new JSpinner();

        var inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.add(new JLabel("1st Number"), gridBagConstraintWith(c, 0, 0));
        inputPanel.add(leftOperandInput, gridBagConstraintWith(c, 1, 0));
        inputPanel.add(new JLabel("2nd Number"), gridBagConstraintWith(c, 0, 1));
        inputPanel.add(rightOperandInput, gridBagConstraintWith(c, 1, 1));

        add(inputPanel, gridBagConstraintWith(c, 0, 0));

        var sumButton = new JButton("Сложить их");
        sumButton.addActionListener(actionEvent -> {
            var leftOperand = (Integer) leftOperandInput.getValue();
            var rightOperand = (Integer) rightOperandInput.getValue();
            JOptionPane.showMessageDialog(this, "Сумма: " + (leftOperand + rightOperand));
        });
        add(sumButton, gridBagConstraintWith(c, 0, 1));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    private static GridBagConstraints gridBagConstraintWith(GridBagConstraints c, int gridX, int gridY) {
        c.gridx = gridX;
        c.gridy = gridY;
        return c;
    }
}
