package practice23.exercise3;

public record MultiplyNode(ExpressionNode a, ExpressionNode b) implements ExpressionNode {
    @Override
    public int evaluate(ExpressionContext context) {
        return Math.multiplyExact(a.evaluate(context), b.evaluate(context));
    }
}
