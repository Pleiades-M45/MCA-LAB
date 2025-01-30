import java.util.Scanner;

class Fact{
    public static int calcFact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = scanner.nextInt();

        System.out.println("Factorial of " + n + " = " + Fact.calcFact(n));

        scanner.close();
    }
}