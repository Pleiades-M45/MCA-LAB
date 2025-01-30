import java.util.Scanner;

class CheckPrime {
    public boolean display(int n) {
        if (n < 2) return false; 

        for (int i = 2; i <= Math.sqrt(n); i++) { 
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckPrime ob = new CheckPrime();

        System.out.print("Enter number: ");
        int n = scanner.nextInt();

        if (ob.display(n)) {
            System.out.println(n + " is Prime");
        } 
        else {
            System.out.println(n + " is not Prime");
        }

        scanner.close();
    }
}