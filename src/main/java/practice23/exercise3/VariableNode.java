package practice23.exercise3;

public record VariableNode(String name) implements ExpressionNode {
    @Override
    public int evaluate(ExpressionContext context) {
        return context.getVariableValue(name);
    }
}
