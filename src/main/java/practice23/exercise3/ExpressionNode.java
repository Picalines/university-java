package practice23.exercise3;

import java.util.Scanner;

public interface ExpressionNode {
    int evaluate(ExpressionContext context);

    static void main(String[] args) {
        ExpressionNode expression = new SubtractNode(
            new MultiplyNode(new ConstNode(2), new VariableNode("x")),
            new ConstNode(3)
        );

        var context = new ExpressionContext();
        context.defineVariable("x", 5);

        System.out.println("2x - 3 = " + expression.evaluate(context) + ", x = 5");

        expression = new AddNode(
            new SubtractNode(
                new MultiplyNode(new VariableNode("x"), new VariableNode("x")),
                new MultiplyNode(new ConstNode(2), new VariableNode("x"))
            ),
            new ConstNode(1)
        );

        System.out.println("f(x) = x^2 - 2x + 1");
        System.out.print("Введите x: ");
        var userX = Integer.parseInt(new Scanner(System.in).nextLine());

        context.defineVariable("x", userX);

        System.out.println("f(" + userX + ") = " + expression.evaluate(context));
    }
}
