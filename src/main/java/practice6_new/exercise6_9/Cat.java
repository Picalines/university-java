package practice6_new.exercise6_9;

import practice6_new.exercise3.Nameable;
import practice6_new.exercise4.Priceable;

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
