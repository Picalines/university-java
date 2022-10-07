package practice6_new;

public class ShopTest {
    public static void main(String[] args) {
        var shop = new Shop();

        shop.addItem(new Cat("Vasya", 1000));
        shop.addItem(new Dog("Max", 1500));

        var book = new Book("First practice", "me", 2000, 3);
        book.setPage(0, "public class Dog {\n    // ...\n}");
        book.setPage(1, "public class Ball {\n    // ...\n}");
        book.setPage(2, "public class Book {\n    // ...\n}");

        shop.addItem(book);

        var computer = new Computer(
            "My computer",
            500,
            new Processor(Manufacturer.Intel, 2000, 5000),
            new Memory(Manufacturer.Kingston, 1500, 2000),
            new Monitor(Manufacturer.LG, 1500, 2560, 1440));

        shop.addItem(computer);

        shop.print();
    }
}
