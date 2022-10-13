package practice6_new;

import practice3.Movable;
import practice3.MovablePoint;

public class MovableRectangle implements Movable {
    private final practice3.MovablePoint topLeft;
    private final practice3.MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft = new practice3.MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);

        if (topLeft.getXSpeed() != bottomRight.getXSpeed() || topLeft.getYSpeed() != bottomRight.getYSpeed()) {
            throw new RuntimeException("speeds of two MovablePoints in MovableRectangle are not equal");
        }
    }

    @Override
    public void moveUp() {
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    @Override
    public String toString() {
        return "MovableRectangle(topLeft: " + topLeft + ", bottomRight: " + bottomRight + ")";
    }
}