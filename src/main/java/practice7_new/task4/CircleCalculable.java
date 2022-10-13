package practice7_new.task4;

public class CircleCalculable implements MathCalculable {
    @Override
    public Complex pow(Complex complex, int base) {
        throw new RuntimeException("why???");
    }

    @Override
    public double abs(Complex complex) {
        throw new RuntimeException("why???");
    }

    public double length(double r) {
        return 2 * PI * r;
    }

    public static void main(String[] args) {
        var cc = new CircleCalculable();
        System.out.println(cc.length(5));
    }
}
