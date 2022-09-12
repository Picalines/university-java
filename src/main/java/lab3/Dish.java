package lab3;

public abstract class Dish {
    private final String name;
    private boolean isDestroyed;

    public Dish(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    protected abstract void washInternal();

    public final void wash() {
        if (isDestroyed) {
            throw new IllegalStateException("can't wash destroyed dish");
        }

        washInternal();
    }

    public final void destroy() {
        isDestroyed = true;
    }

    @Override
    public String toString() {
        return "Dish(name: " + name + ", isDestroyed: " + isDestroyed + ")";
    }
}
