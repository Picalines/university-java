package practice23.exercise3;

public record NegateNode(ExpressionNode expression) implements ExpressionNode {
    @Override
    public int evaluate(ExpressionContext context) {
        return -expression.evaluate(context);
    }
}
