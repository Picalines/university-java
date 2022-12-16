package practice31;

public record Dish(double cost, String name, String description) implements Item {
    public Dish {
        if (cost < 0 || name.equals("") || description.equals("")) {
            throw new IllegalArgumentException();
        }
    }
}
