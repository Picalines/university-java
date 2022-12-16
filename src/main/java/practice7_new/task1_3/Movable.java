package practice7_new.task1_3;

public interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();

    static void main(String[] args) {
        System.out.println("--- MovablePoint test ---");
        testMovable(new MovablePoint(3, 3, 2, 1));
        System.out.println("--- MovableRectangle test ---");
        testMovable(new MovableRectangle(0, 0, 5, 3, 2, 1));
    }

    private static void testMovable(Movable movable) {
        System.out.println("initial: " + movable);
        movable.moveUp();
        System.out.println("moved up: " + movable);
        movable.moveDown();
        System.out.println("moved down: " + movable);
        movable.moveLeft();
        System.out.println("moved left: " + movable);
        movable.moveRight();
        System.out.println("moved right: " + movable);
    }
}
