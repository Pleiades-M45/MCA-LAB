import java.util.Scanner;

interface Printable {
    public void display();
    public void show();
}

interface Computable {
    public double area();
    public double perimeter();
    public double volume();  
}

interface Drawable {
    public void draw(); 
}

class Rectangle implements Printable, Computable, Drawable {
    double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void display() {
        System.out.println("Length = "+length+", Width = "+width);
    
    }

    @Override
    public void show() {}

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public double volume() {
        return -1; 
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle...");
    }
}

class Sphere implements Printable, Computable, Drawable {
    double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public void display() {
        System.out.println("Radius = "+radius);
    }

    @Override
    public void show() {}

    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Sphere...");
    }
}

public class RDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length and width of the Rectangle: ");
        double length = sc.nextDouble();
        double width = sc.nextDouble();
        
        Rectangle r = new Rectangle(length, width);
        r.display();
        r.show();
        System.out.printf("Area = %.2f\n", r.area());
        System.out.printf("Perimeter = %.2f\n", r.perimeter());
        System.out.printf("Volume = %.2f\n", (double) r.volume());
        r.draw();

        System.out.print("\nEnter radius of the Sphere: ");
        double radius = sc.nextDouble();
        
        Sphere s = new Sphere(radius);
        s.display();
        s.show();
        System.out.printf("Area = %.2f\n", s.area());
        System.out.printf("Perimeter = %.2f\n", s.perimeter());
        System.out.printf("Volume = %.2f\n", s.volume());
        s.draw();

        sc.close();
    }
}

/*
Sample Input/Output:

Enter length and width of the Rectangle: 2 3
Length = 2.0, Width = 3.0
Area = 6.00
Perimeter = 10.00
Volume = -1.00
Drawing Rectangle...

Enter radius of the Sphere: 2
Radius = 2.0
Area = 50.27
Perimeter = 12.57
Volume = 33.51
Drawing Sphere...
*/