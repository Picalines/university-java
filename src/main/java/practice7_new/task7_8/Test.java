package practice7_new.task7_8;

public class Test {
    public static void main(String[] args) {
        var printables = new Printable[] {
            new Magazine("first magazine"),
            new Magazine("second magazine"),
            new Magazine("third magazine"),
            new Book("first book"),
            new Book("second book"),
            new Book("third book"),
        };

        System.out.println("magazines:");
        Magazine.printMagazines(printables);

        System.out.println("books:");
        Book.printBooks(printables);
    }
}
