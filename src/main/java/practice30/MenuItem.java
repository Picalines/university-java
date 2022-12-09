package practice30;

public class MenuItem {
    private final String name;
    private final String description;
    private final double cost;

    public MenuItem(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + " (" + description + "; " + cost + ")";
    }
}
