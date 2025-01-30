import java.util.Scanner;

class Table {
    public void display(int n) { 
        for (int i = 1; i <= 10; i++) { 
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }
}

public class MultTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Table ob = new Table();

        System.out.print("Enter number: ");
        int n = scanner.nextInt();

        ob.display(n);

        scanner.close();
    }
}