package practice6_new;

public class Dog implements Nameable, Priceable {
    private final String name;
    private final double price;

    public Dog(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
