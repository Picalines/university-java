package practice6_new;

public class Cat implements Nameable, Priceable {
    private final String name;
    private final double price;

    public Cat(String name, double price) {
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
