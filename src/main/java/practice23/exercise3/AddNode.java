package practice23.exercise3;

public record AddNode(ExpressionNode a, ExpressionNode b) implements ExpressionNode{
    @Override
    public int evaluate(ExpressionContext context) {
        return Math.addExact(a.evaluate(context), b.evaluate(context));
    }
}
