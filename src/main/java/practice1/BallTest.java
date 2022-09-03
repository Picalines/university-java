package practice1;

public class BallTest {
    public static void main(String[] args) {
        var ball = new Ball("orange", 10);
        System.out.println(ball);

        ball.setRadius(15.5);
        ball.setColor("red");
        System.out.println(ball);
    }
}
