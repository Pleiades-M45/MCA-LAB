package arithmetic;

public class Sub implements Computable {
    public double a, b;

    public Sub(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculate() {
        return a - b;
    }
}