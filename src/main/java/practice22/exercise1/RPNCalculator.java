package practice22.exercise1;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class RPNCalculator {
    private final Stack<Double> stack;

    public RPNCalculator() {
        stack = new Stack<>();
    }

    public double evaluate(Iterable<RPNOperation> operations) throws RPNEvaluationException {
        stack.clear();

        try {
            for (var operation : operations) {
                operation.evaluate(stack);
            }

            if (stack.isEmpty()) {
                throw new EmptyStackException();
            } else if (stack.size() != 1) {
                throw new IllegalStateException();
            }
        }
        catch (Throwable throwable) {
            throw new RPNEvaluationException(throwable);
        }

        return stack.pop();
    }

    public double evaluate(RPNOperation[] operations) throws RPNEvaluationException {
        return evaluate(Arrays.asList(operations));
    }

    public static void main(String[] args) throws RPNEvaluationException {
        System.out.print("4 + 2.5 * 2 = ");

        System.out.println(new RPNCalculator().evaluate(new RPNOperation[] {
            new PushNumberOperation(4),
            new PushNumberOperation(2.5),
            new PushNumberOperation(2),
            BinaryOperation.MULTIPLY,
            BinaryOperation.ADD,
        }));
    }
}
