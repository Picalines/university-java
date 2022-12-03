package practice23.exercise4;

import practice23.exercise3.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var expressionParser = createExpressionParser();

        System.out.print("Введите выражение:\n> ");
        var input = new Scanner(System.in).nextLine();
        var tokens = Tokenizer.tokenize(input);

        var parseResult = expressionParser.parse(new TokenReader(tokens));
        if (!parseResult.isSuccess()) {
            var error = parseResult.getError();
            System.out.print("  ");
            for (int i = 0; i < error.position(); i++) {
                System.out.print(" ");
            }
            System.out.println("^");
            System.out.println("Ошибка в выражении: " + error.message());
            return;
        }

        var expression = parseResult.getValue();

        System.out.println("x | f");

        var expressionContext = new ExpressionContext();

        for (int i = 0; i <= 10; i++) {
            expressionContext.defineVariable("x", i);

            System.out.print(i + " | ");

            try {
                System.out.println(expression.evaluate(expressionContext));
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Parser<ExpressionNode> createExpressionParser() {
        var expression = new MutableReference<Parser<ExpressionNode>>();

        Parser<ExpressionNode> expressionInParenthesis =
            TokenParser.of(TokenType.OPENING_PARENTHESIS)
                .then(t -> expression.getValue())
                .then(innerExpression -> TokenParser.of(TokenType.CLOSING_PARENTHESIS)
                    .map(t -> innerExpression));

        Parser<ExpressionNode> number = TokenParser.of(TokenType.NUMBER)
            .map(token -> (ExpressionNode)new ConstNode(Integer.parseInt(token.value())))
            .errorOnException(NumberFormatException.class, e -> "invalid number format");

        Parser<ExpressionNode> variable = TokenParser.of(TokenType.VARIABLE)
            .map(token -> new VariableNode(token.value()));

        Parser<ExpressionNode> primaryTerm = Parser.oneOf(
            number,
            variable,
            expressionInParenthesis
        );

        Parser<ExpressionNode> signedTerm = TokenParser.of(TokenType.OPERATOR_MINUS)
            .then(primaryTerm.map(term -> (ExpressionNode) new NegateNode(term)))
            .or(primaryTerm);

        Parser<ExpressionNode> multiplication = Parser.chainOperator(
            TokenParser.of(TokenType.OPERATOR_MULTIPLY).or(TokenParser.of(TokenType.OPERATOR_DIVIDE)),
            signedTerm,
            (operator, left, right) -> operator.type() == TokenType.OPERATOR_MULTIPLY
                ? new MultiplyNode(left, right)
                : new DivideNode(left, right)
        );

        Parser<ExpressionNode> addition = Parser.chainOperator(
            TokenParser.of(TokenType.OPERATOR_PLUS).or(TokenParser.of(TokenType.OPERATOR_MINUS)),
            multiplication,
            (operator, left, right) -> operator.type() == TokenType.OPERATOR_PLUS
                ? new AddNode(left, right)
                : new SubtractNode(left, right)
        );

        expression.setValue(addition);

        return expression.getValue();
    }
}
