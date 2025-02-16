import java.util.Scanner;

interface Objects {
    public double area();
    public double perimeter();
}

class Circle implements Objects {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public void display() {
        System.out.println("\nArea of Circle      = " + area());
        System.out.println("Perimeter of Circle = " + perimeter());
    }
}

class Rectangle implements Objects {
    double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    public void display() {
        System.out.println("\nArea of Rectangle      = " + area());
        System.out.println("Perimeter of Rectangle = " + perimeter());
    }
}

public class AreaMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        while (true) {
            System.out.print("\n1.Circle\n2.Rectangle\n3.Exit\nEnter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter radius of the Circle: ");
                    double radius = sc.nextDouble();

                    Circle c = new Circle(radius);
                    c.display();
                    break;

                case 2:
                    System.out.print("\nEnter length and width of the Rectangle: ");
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();

                    Rectangle r = new Rectangle(length, width);
                    r.display();
                    break;

                case 3:
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("\nInvalid Choice!");
                    break;
            }
        }
    }
}

/*
Sample Input/Output:

1.Circle
2.Rectangle
3.Exit
Enter your choice : 1

Enter radius of the Circle: 5

Area of Circle      = 78.53981633974483
Perimeter of Circle = 31.41592653589793

1.Circle
2.Rectangle
3.Exit
Enter your choice : 2

Enter length and width of the Rectangle: 2 3

Area of Rectangle      = 6.0
Perimeter of Rectangle = 10.0

1.Circle
2.Rectangle
3.Exit
Enter your choice : 3
*/