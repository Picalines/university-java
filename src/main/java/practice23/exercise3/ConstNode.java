package practice23.exercise3;

public record ConstNode(int value) implements ExpressionNode {
    @Override
    public int evaluate(ExpressionContext context) {
        return value;
    }
}
