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

/*
Sample Input/Output:

Enter number: 5
5 * 1 = 5
5 * 2 = 10
5 * 3 = 15
5 * 4 = 20
5 * 5 = 25
5 * 6 = 30
5 * 7 = 35
5 * 8 = 40
5 * 9 = 45
5 * 10 = 50
 */