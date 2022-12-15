package practice6_new.exercise12;

import java.util.function.Function;
import java.util.function.Supplier;

public final class FunctionQueue<T> {
    private final ActionQueue actionQueue;
    private final Supplier<T> initialValueSupplier;
    private T lastFunctionResult;

    public FunctionQueue(Supplier<T> initialValueSupplier) {
        actionQueue = new ActionQueue();
        this.initialValueSupplier = initialValueSupplier;
    }

    public void apply(Function<T, T> function) {
        actionQueue.add(() -> lastFunctionResult = function.apply(lastFunctionResult));
    }

    public void undo() {
        actionQueue.undo();
    }

    public T call() {
        lastFunctionResult = initialValueSupplier.get();
        actionQueue.perform();
        return lastFunctionResult;
    }
}
