package practice1;

public class Ball {
    private String color;
    private double radius;

    public Ball(String color, double radius) {
        setColor(color);
        setRadius(radius);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Ball { color: " + color + ", radius: " + radius + " }";
    }
}
