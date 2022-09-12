package lab5;

import java.awt.*;

public final class Rectangle extends Shape {
    private final int width;
    private final int height;

    public Rectangle(Point position, int width, int height, Color color) {
        super(position, color);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void paint(Graphics2D graphics2D) {
        graphics2D.setColor(color);
        graphics2D.fillRect(position.x, position.y, width, height);
    }
}
