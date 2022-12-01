package practice23.exercise3;

public record DivideNode(ExpressionNode a, ExpressionNode b) implements ExpressionNode {
    @Override
    public int evaluate(ExpressionContext context) {
        var aResult = a.evaluate(context);
        var bResult = b.evaluate(context);

        if (bResult == 0) {
            throw new ArithmeticException("division by zero");
        }

        return Math.divideExact(aResult, bResult);
    }
}
