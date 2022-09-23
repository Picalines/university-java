package practice3_new.part1;

import java.util.Arrays;
import java.util.Comparator;

record Point(double x, double y) { }

record Circle(Point center, double radius) { }

class Tester {
    private final Circle[] circles;

    public Tester() {
        circles = new Circle[(int)(Math.random() * 9 + 1)];

        for (int i = 0; i < circles.length; i++) {
            var center = new Point(Math.random() * 100, Math.random() * 100);
            circles[i] = new Circle(center, Math.random() * 100);
        }
    }

    public Circle biggestCircle() {
        return Arrays.stream(circles).max(Comparator.comparingDouble(Circle::radius)).orElse(null);
    }

    public Circle smallestCircle() {
        return Arrays.stream(circles).min(Comparator.comparingDouble(Circle::radius)).orElse(null);
    }

    public void sortByRadius() {
        Arrays.sort(circles, Comparator.comparingDouble(Circle::radius));
    }

    public void printCircles() {
        for (var circle : circles) {
            System.out.println(circle);
        }
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        var tester = new Tester();

        System.out.println("initial:");
        tester.printCircles();
        System.out.println();

        System.out.println("min: " + tester.smallestCircle());
        System.out.println("max: " + tester.biggestCircle());
        System.out.println();

        tester.sortByRadius();
        System.out.println("sorted: ");
        tester.printCircles();
    }
}
