package practice23.exercise4;

import java.util.List;
import java.util.Optional;

public class TokenReader {
    private final List<Token> tokens;
    private int position;

    public TokenReader(List<Token> tokens) {
        position = 0;
        this.tokens = tokens;
    }

    public Optional<Token> currentToken() {
        return position < tokens.size()
            ? Optional.of(tokens.get(position))
            : Optional.empty();
    }

    public void advance() {
        do {
            position = Math.min(position + 1, tokens.size());
        } while (position < tokens.size() && tokens.get(position).type() == TokenType.SPACE);
    }

    public int getPosition() {
        return currentToken().map(Token::sourcePosition).orElseGet(() -> {
            if (tokens.isEmpty()) {
                return 0;
            }
            var lastToken = tokens.get(tokens.size() - 1);
            return lastToken.sourcePosition() + lastToken.value().length();
        });
    }
}
