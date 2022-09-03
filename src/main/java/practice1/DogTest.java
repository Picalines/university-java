package practice1;

public class DogTest {
    public static void main(String[] args) {
        var dog = new Dog("Max", 0);
        System.out.println(dog);

        dog.setAge(dog.getAge() + 5);
        dog.setName("Max II");
        System.out.println(dog);

        System.out.println("age in human years: " + dog.getAgeInHumanYears());
    }
}
