package practice6_new;

enum Manufacturer {
    Intel,
    AMD,
    Kingston,
    NVIDIA,
    LG,
}

record Processor(Manufacturer manufacturer, double price, double frequency) implements Nameable, Priceable {
    @Override
    public String getName() {
        return manufacturer.toString() + "X" + frequency;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

record Memory(Manufacturer manufacturer, double price, int GBVolume) implements Nameable, Priceable {
    @Override
    public String getName() {
        return manufacturer.toString() + "@" + GBVolume + "GB";
    }

    @Override
    public double getPrice() {
        return price;
    }
}

record Monitor(Manufacturer manufacturer, double price, int width, int height) implements Nameable, Priceable {
    @Override
    public String getName() {
        return manufacturer.toString() + "@" + width + "/" + height + "px";
    }

    @Override
    public double getPrice() {
        return price;
    }
}

public record Computer(String name, double basePrice, Processor processor, Memory memory, Monitor monitor)
    implements Nameable, Priceable, Printable {
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return basePrice + processor.getPrice() + memory.getPrice() + monitor.getPrice();
    }

    @Override
    public void print() {
        System.out.println(getName() + ':');
        System.out.println("* processor: " + processor.toString());
        System.out.println("* memory: " + memory.toString());
        System.out.println("* monitor: " + monitor.toString());
    }
}
