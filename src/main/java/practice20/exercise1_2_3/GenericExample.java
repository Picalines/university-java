package practice20.exercise1_2_3;

import java.io.Serializable;

public class GenericExample<T extends Comparable<String>, V extends Animal & Serializable, K> {
    private final T firstValue;
    private final V secondValue;
    private final K thirdValue;

    public GenericExample(T firstValue, V secondValue, K thirdValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
    }

    public T getFirstValue() {
        return firstValue;
    }

    public V getSecondValue() {
        return secondValue;
    }

    public K getThirdValue() {
        return thirdValue;
    }

    public void printTypeArgNames() {
        System.out.println("T: " + firstValue.getClass().getName());
        System.out.println("V: " + secondValue.getClass().getName());
        System.out.println("K: " + thirdValue.getClass().getName());
    }

    public static void main(String[] args) {
        var example = new GenericExample<>("", new Cat("max", 25), 123);
        example.printTypeArgNames();
    }
}
