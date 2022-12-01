package practice23.exercise4;

record ParseError(String message, int position) { }

public class ParseResult<T> {
    private final boolean isSuccess;

    private final T value;

    private final ParseError error;

    private ParseResult(T value) {
        isSuccess = true;
        this.value = value;
        this.error = null;
    }

    private ParseResult(ParseError error) {
        isSuccess = false;
        this.value = null;
        this.error = error;
    }

    public static <T> ParseResult<T> success(T value) {
        return new ParseResult<>(value);
    }

    public static <T> ParseResult<T> error(String errorMessage, int position) {
        return new ParseResult<>(new ParseError(errorMessage, position));
    }

    public <U> ParseResult<U> castError() {
        if (isSuccess) throw new IllegalStateException();
        return new ParseResult<>(error);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public T getValue() {
        if (!isSuccess) throw new IllegalStateException();
        return value;
    }

    public ParseError getError() {
        if (isSuccess) throw new IllegalStateException();
        return error;
    }
}
