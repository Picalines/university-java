package practice7_new.task4;

record Complex(double real, double imaginary) {}

public interface MathCalculable {
    double PI = Math.PI;

    Complex pow(Complex complex, int base);

    double abs(Complex complex);
}
