package practice6_new.exercise3;

import practice6_new.exercise6_9.Cat;
import practice6_new.exercise6_9.Dog;

public class NameableTest {
    public static void main(String[] args) {
        var cat = new Cat("Vasya", 100);
        var dog = new Dog("Max", 150);

        System.out.println("cat name: " + cat.getName());
        System.out.println("dog name: " + dog.getName());

        System.out.println("cat price: " + cat.getPrice());
        System.out.println("dog price: " + dog.getPrice());
    }
}
