package practice23.exercise3;

public record SubtractNode(ExpressionNode a, ExpressionNode b) implements ExpressionNode {
    @Override
    public int evaluate(ExpressionContext context) {
        return a.evaluate(context) - b.evaluate(context);
    }
}
