package practice23.exercise4;

import java.util.function.Function;

public abstract class Parser<T> {
    public abstract ParseResult<T> parse(TokenReader tokenReader);

    public final <U> Parser<U> then(Function<T, Parser<U>> selectNextParser) {
        var currentParser = this;

        return new Parser<>() {
            @Override
            public ParseResult<U> parse(TokenReader tokenReader) {
                var currentResult = currentParser.parse(tokenReader);
                if (!currentResult.isSuccess()) {
                    return currentResult.castError();
                }

                return selectNextParser.apply(currentResult.getValue()).parse(tokenReader);
            }
        };
    }

    public final <U> Parser<U> then(Parser<U> nextParser) {
        return then(v -> nextParser);
    }

    public final <U> Parser<U> map(Function<T, U> map) {
        var parser = this;

        return new Parser<>() {
            @Override
            public ParseResult<U> parse(TokenReader tokenReader) {
                var result = parser.parse(tokenReader);
                if (!result.isSuccess()) {
                    return result.castError();
                }

                return ParseResult.success(map.apply(result.getValue()));
            }
        };
    }

    public final Parser<T> or(Parser<T> secondParser) {
        var firstParser = this;

        return new Parser<>() {
            @Override
            public ParseResult<T> parse(TokenReader tokenReader) {
                var initialPosition = tokenReader.getPosition();
                var firstResult = firstParser.parse(tokenReader);

                if (firstResult.isSuccess() || firstResult.getError().position() != initialPosition) {
                    return firstResult;
                }

                return secondParser.parse(tokenReader);
            }
        };
    }

    public final <E extends Throwable> Parser<T> errorOnException(Class<E> exceptionClass, Function<E, String> createErrorMessage) {
        var parser = this;

        return new Parser<>() {
            @Override
            public ParseResult<T> parse(TokenReader tokenReader) {
                try {
                    return parser.parse(tokenReader);
                } catch (Throwable throwable) {
                    if (exceptionClass.isAssignableFrom(throwable.getClass())) {
                        @SuppressWarnings("unchecked")
                        var exception = (E) throwable;
                        return ParseResult.error(createErrorMessage.apply(exception), tokenReader.getPosition());
                    }

                    throw throwable;
                }
            }
        };
    }

    public final Parser<T> atEnd() {
        var parser = this;

        return new Parser<>() {
            @Override
            public ParseResult<T> parse(TokenReader tokenReader) {
                var result = parser.parse(tokenReader);

                tokenReader.advance();

                if (result.isSuccess() && tokenReader.currentToken().isPresent()) {
                    return ParseResult.error(
                        "unexpected token " + tokenReader.currentToken().get().type() + " (expected end of input)",
                        tokenReader.getPosition());
                }

                return result;
            }
        };
    }

    @SafeVarargs
    public static <T> Parser<T> oneOf(Parser<T>... parsers) {
        if (parsers.length == 1) {
            throw new IllegalArgumentException("empty parsers array");
        }

        var compositeParser = parsers[0];
        for (int i = 1; i < parsers.length; i++) {
            compositeParser = compositeParser.or(parsers[i]);
        }

        return compositeParser;
    }

    public interface ChainedExpressionCreator<T, TOp> {
        T create(TOp operator, T left, T right);
    }

    public static <T, TOp> Parser<T> chainOperator(Parser<TOp> operator, Parser<T> term, ChainedExpressionCreator<T, TOp> createExpression) {
        return new Parser<>() {
            @Override
            public ParseResult<T> parse(TokenReader tokenReader) {
                var firstTermResult = term.parse(tokenReader);

                if (!firstTermResult.isSuccess()) {
                    return firstTermResult;
                }

                return parseRest(tokenReader, firstTermResult.getValue());
            }

            private ParseResult<T> parseRest(TokenReader tokenReader, T firstTerm) {
                var initialPosition = tokenReader.getPosition();
                var operatorResult = operator.parse(tokenReader);
                if (!operatorResult.isSuccess()) {
                    return operatorResult.getError().position() == initialPosition
                        ? ParseResult.success(firstTerm)
                        : operatorResult.castError();
                }

                var secondTermResult = term.parse(tokenReader);
                if (!secondTermResult.isSuccess()) {
                    return secondTermResult;
                }

                return parseRest(tokenReader, createExpression.create(operatorResult.getValue(), firstTerm, secondTermResult.getValue()));
            }
        };
    }
}
