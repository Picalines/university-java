package lab5;

import java.awt.*;

public abstract class Shape {
    protected final Point position;
    protected final Color color;

    public Shape(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public abstract void paint(Graphics2D graphics2D);
}
