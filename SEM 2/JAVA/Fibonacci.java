import java.util.Scanner;

class Fibo {
    public static void display(int n) {
        int a = 0, b = 1, c;
        for (int i = 1; i <= n; i++) { 
            System.out.print(a + "\t");
            c = a + b;
            a = b;
            b = c;
        }
    }
}

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = scanner.nextInt();

        Fibo.display(n);

        scanner.close();
    }
}