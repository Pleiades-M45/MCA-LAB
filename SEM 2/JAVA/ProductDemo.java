import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price;
    }

}

public class ProductDemo {
    static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(Scanner sc) {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        products.add(new Product(name, price));
        System.out.println(name + " added successfully !");
    }

    public static void sortProducts() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        System.out.print("\tSorted List\n");
        displayProducts();
    }

    public static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Empty List!");
        } else {
            System.out.println("----------------------------");
            for (Product x : products) {
                System.out.println(x);
            }
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.print("\n1.Add Product\n2.Sort Products\n3.Display\n4.Exit\nEnter your choice: ");
            ch = sc.nextInt();
            sc.nextLine();
            System.out.print("\n");

            switch (ch) {
                case 1:
                    addProduct(sc);
                    break;

                case 2:
                    sortProducts();
                    break;

                case 3:
                    displayProducts();
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}

/*
Sample Input/Output:

1.Add Product
2.Sort Products
3.Display
4.Exit
Enter your choice: 1

Enter product name: Phone
Enter product price: 500
Phone added successfully !

1.Add Product
2.Sort Products
3.Display
4.Exit
Enter your choice: 1

Enter product name: Laptop
Enter product price: 800
Laptop added successfully !

1.Add Product
2.Sort Products
3.Display
4.Exit
Enter your choice: 3

----------------------------
Name: Phone, Price: 500.0
Name: Laptop, Price: 800.0
----------------------------

1.Add Product
2.Sort Products
3.Display
4.Exit
Enter your choice: 2

        Sorted List
----------------------------
Name: Laptop, Price: 800.0
Name: Phone, Price: 500.0
----------------------------

1.Add Product
2.Sort Products
3.Display
4.Exit
Enter your choice: 4

Exiting the program...
*/