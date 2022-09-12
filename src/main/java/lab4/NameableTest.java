package lab4;

public class NameableTest {
    public static void main(String[] args) {
        Nameable cat = new Cat("Vasya");
        Nameable dog = new Dog("Max");

        System.out.println("cat name: " + cat.getName());
        System.out.println("dog name: " + dog.getName());
    }
}
