package practice22.exercise1;

import java.util.EmptyStackException;
import java.util.Stack;

public enum BinaryOperation implements RPNOperation {
    ADD(Double::sum),
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> a / b);

    private interface Evaluator {
        double evaluate(double left, double right);
    }

    private final Evaluator evaluator;

    BinaryOperation(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public void evaluate(Stack<Double> stack) throws EmptyStackException {
        var right = stack.pop();
        var left = stack.pop();

        stack.push(evaluator.evaluate(left, right));
    }
}
