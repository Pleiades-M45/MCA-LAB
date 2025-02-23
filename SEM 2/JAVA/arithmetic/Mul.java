package arithmetic;

public class Mul implements Computable {
    public double a, b;

    public Mul(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculate() {
        return a * b;
    }
}