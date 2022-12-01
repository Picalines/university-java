package practice22.exercise1;

import java.util.Stack;

public record PushNumberOperation(double value) implements RPNOperation {
    @Override
    public void evaluate(Stack<Double> stack) {
        stack.push(value);
    }
}
