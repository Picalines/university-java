package practice23.exercise4;

public final class TokenParser extends Parser<Token> {
    private final TokenType expectedTokenType;

    private TokenParser(TokenType expectedTokenType) {
        this.expectedTokenType = expectedTokenType;
    }

    public static TokenParser of(TokenType expectedTokenType) {
        return new TokenParser(expectedTokenType);
    }

    @Override
    public ParseResult<Token> parse(TokenReader tokenReader) {
        var currentToken = tokenReader.currentToken().orElse(null);

        if (currentToken == null) {
            return ParseResult.error("Unexpected end of input (expected " + expectedTokenType + ")", tokenReader.getPosition());
        }

        if (currentToken.type() != expectedTokenType) {
            return ParseResult.error("Unexpected token " + currentToken.type() + " (expected " + expectedTokenType + ")", tokenReader.getPosition());
        }

        tokenReader.advance();
        return ParseResult.success(currentToken);
    }
}
