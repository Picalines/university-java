package practice3_new.part2;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("task 1:");
        for (int i = 0; i < 5; i++) {
            System.out.println(Double.valueOf(i + ".5"));
        }

        System.out.println("task 2:");
        System.out.println(Double.parseDouble("123.456"));

        System.out.println("task 3:");
        var dbl = Double.valueOf(789.012);
        System.out.println("doubleValue: " + dbl.doubleValue());
        System.out.println("floatValue: " + dbl.floatValue());
        System.out.println("longValue: " + dbl.longValue());
        System.out.println("intValue: " + dbl.intValue());
        System.out.println("shortValue: " + dbl.shortValue());
        System.out.println("byteValue: " + dbl.byteValue());

        System.out.println("task 4:");
        System.out.println(dbl);

        System.out.println("task 5:");
        String d = Double.toString(3.14);
        System.out.println(d);
    }
}
