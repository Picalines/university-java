package practice6_new;

public class BookTest {
    public static void main(String[] args) {
        var book = new Book("First practice", "me", 100, 3);
        book.setPage(0, "public class Dog {\n    // ...\n}");
        book.setPage(1, "public class Ball {\n    // ...\n}");
        book.setPage(2, "public class Book {\n    // ...\n}");

        book.print();
    }
}
