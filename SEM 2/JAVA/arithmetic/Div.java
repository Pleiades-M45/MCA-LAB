package arithmetic;

public class Div implements Computable {
    public double a, b;

    public Div(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculate() {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }
}