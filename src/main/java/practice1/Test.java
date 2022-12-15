package practice1;

public class Test {
    public static void main(String[] args) {
        System.out.println("--- Dog test ---");
        var dog = new Dog("Max", 0);
        System.out.println(dog);

        dog.setAge(dog.getAge() + 5);
        dog.setName("Max II");
        System.out.println(dog);

        System.out.println("age in human years: " + dog.getAgeInHumanYears());

        System.out.println("--- Ball test ---");
        var ball = new Ball("orange", 10);

        System.out.println(ball);
        ball.setRadius(15.5);
        ball.setColor("red");
        System.out.println(ball);

        System.out.println("--- Book test ---");
        var book = new Book("First practice", "me", 3);
        book.setPage(0, "public class Dog {\n    // ...\n}");
        book.setPage(1, "public class Ball {\n    // ...\n}");
        book.setPage(2, "public class Book {\n    // ...\n}");

        System.out.println(book);

        for (int i = 0; i < book.getPageCount(); i++) {
            System.out.println("* page " + (i + 1) + "/" + book.getPageCount() + ":");
            System.out.println(book.getPage(i));
            System.out.println();
        }
    }
}
