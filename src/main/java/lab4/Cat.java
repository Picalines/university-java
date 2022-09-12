package lab4;

public class Cat implements Nameable {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
