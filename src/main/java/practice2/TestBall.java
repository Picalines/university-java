package practice2;

public class TestBall {
    public static void main(String[] args) {
        var ball = new Ball();
        System.out.println(ball);

        ball.setXY(10, -5);
        System.out.println(ball);

        ball.move(-5.5, 99.9);
        System.out.println(ball);
    }
}
