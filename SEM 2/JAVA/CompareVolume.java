import java.util.Scanner;

interface Comparable {
    public double volume();

    default int compareByVolume(Comparable other) {
        if (volume() < other.volume()) {
            return -1;
        } else if (volume() > other.volume()) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Cuboid implements Comparable {
    double length, width, height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double volume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return String.format("Cuboid (%.2f)", volume());
    }
}

class Cylinder implements Comparable {
    double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return String.format("Cylinder (%.2f)", volume());
    }
}

public class CompareVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Length, Width and Height of Cuboid: ");
        double l = sc.nextDouble();
        double w = sc.nextDouble();
        double h = sc.nextDouble();

        System.out.print("Enter the Radius and Height of Cylinder: ");
        double r = sc.nextDouble();
        double ch = sc.nextDouble();

        sc.close();

        Cuboid c = new Cuboid(l, w, h);
        Cylinder cy = new Cylinder(r, ch);

        int result = c.compareByVolume(cy);
        if (result < 0) {
            System.out.println(c + " is smaller than " + cy);
        } else if (result > 0) {
            System.out.println(c + " is greater than " + cy);
        } else {
            System.out.println(c + " and " + cy + " are equal");
        }
    }
}

/*
Sample Input/Output:

Enter the Length, Width and Height of Cuboid: 2 4 2
Enter the Radius and Height of Cylinder: 2 1.2732395447351628
Cuboid (16.00) and Cylinder (16.00) are equal
*/