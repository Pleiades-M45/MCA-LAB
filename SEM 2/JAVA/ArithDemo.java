import arithmetic.*;

public class ArithDemo {
    public static void main(String[] args) {
        double x = 10, y = 5;

        Add a = new Add(x, y);
        Sub s = new Sub(x, y);
        Mul m = new Mul(x, y);
        Div d = new Div(x, y);

        System.out.println("Addition: " + a.calculate());
        System.out.println("Subtraction: " + s.calculate());
        System.out.println("Multiplication: " + m.calculate());
        System.out.println("Division: " + d.calculate());
    }
}

/*
Sample Input/Output:

Addition: 15.0
Subtraction: 5.0
Multiplication: 50.0
Division: 2.0
*/