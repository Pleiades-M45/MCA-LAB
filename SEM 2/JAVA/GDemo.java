import geometry.shapes3D.*;

public class GDemo {
    public static void main(String[] args) {
        Cuboid c = new Cuboid(2, 3, 4);
        Sphere s = new Sphere(10);

        System.out.println("Rectangle(" + c.len + ", " + c.wid + ")");
        System.out.println("Area: " + c.area() + "\nPerimeter: " + c.perimeter() + "\n");
        System.out.println(c + "\nVolume: " + c.volume());

        System.out.println("\nCircle(" + s.radius + ")");
        System.out.println("Area: " + s.area() + "\nPerimeter: " + s.perimeter() + "\n");
        System.out.println(s + "\nVolume: " + s.volume());
    }
}

/*
Sample Input/Output:

Rectangle(2.0, 3.0)
Area: 6.0
Perimeter: 10.0

Cuboid(2.0, 3.0, 4.0)
Volume: 24.0

Circle(10.0)
Area: 314.1592653589793
Perimeter: 62.83185307179586

Sphere(10.0)
Volume: 4188.790204786391
*/