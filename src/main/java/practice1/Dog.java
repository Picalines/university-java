package practice1;

public class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public int getAgeInHumanYears() {
        return age * 7;
    }

    public String toString() {
        return "Dog { name: '" + name + "', age: " + age + " }";
    }
}
