package practice22.exercise1;

public class RPNEvaluationException extends Exception {
    public RPNEvaluationException(Throwable cause) {
        super("Exception was thrown during RPN evaluation", cause);
    }
}
