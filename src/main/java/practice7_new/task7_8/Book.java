package practice7_new.task7_8;

public record Book(String name) implements Printable {
    @Override
    public void print() {
        System.out.println(name);
    }

    public static void printBooks(Printable[] printables) {
        for (var printable : printables) {
            if (printable instanceof Book book) {
                book.print();
            }
        }
    }
}
