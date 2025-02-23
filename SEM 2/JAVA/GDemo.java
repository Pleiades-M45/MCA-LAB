import geometry.shapes3D.*;

public class GDemo {
    public static void main(String[] args) {
        Cuboid c = new Cuboid(2, 3, 4);
        Sphere s = new Sphere(10);

        System.out.println("Rectangle(" + c.len + "," + c.wid + ")");
        System.out.println("Area: " + c.area() + "\nPerimeter: " + c.perimeter() + "\n");
        System.out.println(c + "\nVolume: " + c.volume());

        System.out.println("\nCircle(" + s.radius + ")");
        System.out.println("Area: " + s.area() + "\nPerimeter: " + s.perimeter() + "\n");
        System.out.println(s + "\nVolume: " + s.volume());
    }
}
