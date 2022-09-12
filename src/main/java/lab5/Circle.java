package lab5;

import java.awt.*;

public final class Circle extends Shape {
    private final int radius;

    public Circle(Point position, int radius, Color color) {
        super(position, color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.fillOval(position.x - radius, position.y - radius, radius * 2, radius * 2);
    }
}
