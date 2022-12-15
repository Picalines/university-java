package practice7_new.task4;

public class CircleCalculable implements MathCalculable {
    @Override
    public Complex pow(Complex complex, int base) {
        return switch (base) {
            case 1 -> complex;
            case 0 -> new Complex(0, 0);
            default -> {
                var sq = pow(complex, base / 2);
                yield base % 2 == 0
                    ? multiply(sq, sq)
                    : multiply(complex, multiply(sq, sq));
            }
        };
    }

    private Complex multiply(Complex a, Complex b) {
        return new Complex(
            (a.real() * b.real()) - (a.imaginary() * b.imaginary()),
            (a.imaginary() * b.real()) + (a.real() * b.imaginary())
        );
    }

    @Override
    public double abs(Complex complex) {
        return Math.sqrt(complex.real() * complex.real() + complex.imaginary() * complex.imaginary());
    }

    public double length(double r) {
        return 2 * PI * r;
    }

    public static void main(String[] args) {
        var cc = new CircleCalculable();
        System.out.println("Circle length = " + cc.length(5) + ", r = 5");
        var c1 = new Complex(1, 2);
        System.out.println("z = " + c1);
        System.out.println("|z| = " + cc.abs(c1));
        System.out.println("z^2 = " + cc.pow(c1, 2));
    }
}
