package practice31;

public record Drink(double cost, String name, String description) implements Item {
    public Drink {
        if (cost < 0 || name.equals("") || description.equals("")) {
            throw new IllegalArgumentException();
        }
    }
}
