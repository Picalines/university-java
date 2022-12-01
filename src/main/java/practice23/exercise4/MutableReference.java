package practice23.exercise4;

public class MutableReference<T> {
    private boolean hasValue = false;
    private T value = null;

    public T getValue() {
        if (!hasValue) {
            throw new IllegalStateException();
        }
        return value;
    }

    public void setValue(T value) {
        this.value = value;
        hasValue = true;
    }
}
