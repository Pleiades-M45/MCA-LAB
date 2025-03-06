import java.util.Scanner;

class NegativeInputException extends Exception {
    public NegativeInputException(String message) {
        super(message);
    }
}

public class AverageException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of integers (N): ");
        int N = sc.nextInt();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            try {
                System.out.print("Enter integer #" + (i + 1) + ": ");
                int num = sc.nextInt();

                if (num < 0) {
                    throw new NegativeInputException("Negative numbers are not allowed!!");
                }

                sum += num;

            } catch (NegativeInputException e) {
                System.out.println(e.getMessage());
                i--;  // Decrement the counter to ask for the same input again
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        double average = (double) sum / N;
        System.out.println("Average = " + average);

        sc.close();
    }
}

/*
Sample Input/Output:

Enter the number of integers (N): 3
Enter integer #1: 10
Enter integer #2: -5
Negative numbers are not allowed!!
Enter integer #2: 20
Enter integer #3: 30
Average = 20.0
*/