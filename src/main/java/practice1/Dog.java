package practice1;

public class Dog {
    private String _name;
    private int _age;

    public Dog(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return _name;
    }

    public void setName(String newName) {
        _name = newName;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int newAge) {
        _age = newAge;
    }

    public int getAgeInHumanYears() {
        return _age * 7;
    }

    public String toString() {
        return "Dog { name: '" + _name + "', age: " + _age + " }";
    }
}
