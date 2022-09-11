package lab2;

public class CircleTest {
    public static void main(String[] args) {
        var circle = new Circle(15);
        System.out.println(circle);
        printCircleStats(circle);

        circle.setRadius(10);
        System.out.println("\nafter setRadius(10):");
        System.out.println(circle);
        printCircleStats(circle);
    }

    private static void printCircleStats(Circle circle) {
        System.out.println("area: " + circle.getArea());
        System.out.println("perimeter: " + circle.getPerimeter());
    }
}
