package practice1;

public class Ball {
    public String _color;
    public double _radius;

    public Ball(String color, double radius) {
        setColor(color);
        setRadius(radius);
    }

    public String getColor() {
        return _color;
    }

    public void setColor(String color) {
        _color = color;
    }

    public double getRadius() {
        return _radius;
    }

    public void setRadius(double radius) {
        _radius = radius;
    }

    public String toString() {
        return "Ball { color: " + _color + ", radius: " + _radius + " }";
    }
}
