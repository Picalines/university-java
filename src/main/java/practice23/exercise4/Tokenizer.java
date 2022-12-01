package practice23.exercise4;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private Tokenizer() {}

    public static List<Token> tokenize(String expression) {
        var tokens = new ArrayList<Token>();
        var currentPosition  = 0;

        while (currentPosition < expression.length()) {
            Token currentToken = null;

            for (var tokenType : TokenType.values()) {
                var matcher = tokenType.getPattern().matcher(expression.substring(currentPosition));

                if (matcher.find() && matcher.start() == 0) {
                    currentToken = new Token(tokenType, matcher.group(), currentPosition);
                    break;
                }
            }

            if (currentToken == null) {
                throw new IllegalArgumentException("Unknown token at index " + currentPosition);
            }

            tokens.add(currentToken);
            currentPosition += currentToken.value().length();
        }

        return tokens;
    }
}
