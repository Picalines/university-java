package practice1;

public class BookTest {
    public static void main(String[] args) {
        var book = new Book("First practice", "me", 3);
        book.setPage(0, "public class Dog {\n    // ...\n}");
        book.setPage(1, "public class Ball {\n    // ...\n}");
        book.setPage(2, "public class Book {\n    // ...\n}");

        System.out.println(book);

        for (int i = 0; i < book.getPageCount(); i++) {
            System.out.println("page " + (i + 1) + "/" + book.getPageCount() + ":");
            System.out.println(book.getPage(i));
            System.out.println();
        }
    }
}
