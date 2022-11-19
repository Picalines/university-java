package practice20.exercise4;

public class Calculator {
    public static <T extends Number, U extends Number> double sum(T a, U b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, U extends Number> double subtract(T a, U b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiply(T a, U b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T a, U b) {
        return a.doubleValue() / b.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(1, 2.0));
        System.out.println(Calculator.subtract(9, 2.0));
        System.out.println(Calculator.multiply(5.0, 2));
        System.out.println(Calculator.divide(10.0, 2));
    }
}
