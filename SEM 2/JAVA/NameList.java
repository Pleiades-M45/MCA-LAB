import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NameList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        
        while (true) {
            System.out.print("\n1.Add\n2.Remove\n3.Search\n4.Sort\n5.Display\n6.Exit\nEnter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            System.out.print("\n");
            
            switch (ch) {
                case 1:
                    System.out.print("Enter the name to add: ");
                    String name = sc.nextLine();
                    names.add(name);
                    System.out.println(name + " added Successfully!\n");
                    break;

                case 2:
                    System.out.print("Enter the name to remove: ");
                    String n = sc.nextLine();
                    if (names.remove(n)) {
                        System.out.println(n + " removed Successfully!\n");
                    } else {
                        System.out.println(n + " not present!\n");
                    }
                    break;

                case 3:
                    System.out.print("Enter the name to search: ");
                    String s = sc.nextLine();
                    if (names.contains(s)) {
                        System.out.println(s + " present at position " + (names.indexOf(s) + 1) + "\n");
                    } else {
                        System.out.println(s + " not present!\n");
                    }
                    break;

                case 4:
                    Collections.sort(names);
                    System.out.println("\tSorted List\n-----------------------");
                    for (String x : names) System.out.println(x);
                    System.out.println("-----------------------\n");
                    break;

                case 5:
                    if (names.isEmpty()) {
                        System.out.println("Empty List!\n");
                    } else {
                        System.out.println("\n-----------------------");
                        for (String x : names) System.out.println(x);
                        System.out.println("-----------------------\n");
                    }
                    break;

                case 6:
                    sc.close();
                    System.exit(0);
                    
                default:
                    System.out.println("\nInvalid Choice !\n");
                    break;
            }
        }
    }
}

/*
Sample Input/Output:

1.Add
2.Remove
3.Search
4.Sort
5.Display
6.Exit
Enter your choice: 1

Enter the name to add: Paimon
Paimon added Successfully!


1.Add
2.Remove
3.Search
4.Sort
5.Display
6.Exit
Enter your choice: 1

Enter the name to add: Aether
Aether added Successfully!


1.Add
2.Remove
3.Search
4.Sort
5.Display
6.Exit
Enter your choice: 5


-----------------------
Paimon
Aether
-----------------------


1.Add
2.Remove
3.Search
4.Sort
5.Display
6.Exit
Enter your choice: 4

        Sorted List
-----------------------
Aether
Paimon
-----------------------


1.Add
2.Remove
3.Search
4.Sort
5.Display
6.Exit
Enter your choice: 3

Enter the name to search: Paimon
Paimon present at position 2


1.Add
2.Remove
3.Search
4.Sort
5.Display
6.Exit
Enter your choice: 2

Enter the name to remove: Aether
Aether removed Successfully!


1.Add
2.Remove
3.Search
4.Sort
5.Display
6.Exit
Enter your choice: 5


-----------------------
Paimon
-----------------------


1.Add
2.Remove
3.Search
4.Sort
5.Display
6.Exit
Enter your choice: 6
*/