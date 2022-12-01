package practice23.exercise4;

import java.util.regex.Pattern;

public enum TokenType {
    SPACE(Pattern.compile("\\s+")),
    NUMBER(Pattern.compile("\\b\\d+\\b")),
    VARIABLE(Pattern.compile("\\b[a-zA-Z]\\w*\\b")),
    OPERATOR_PLUS(Pattern.compile("\\+")),
    OPERATOR_MINUS(Pattern.compile("-")),
    OPERATOR_MULTIPLY(Pattern.compile("\\*")),
    OPERATOR_DIVIDE(Pattern.compile("/")),
    OPENING_PARENTHESIS(Pattern.compile("\\(")),
    CLOSING_PARENTHESIS(Pattern.compile("\\)"));

    private final Pattern pattern;

    TokenType(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
