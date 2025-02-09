class Volume {
    public double calc_volume(double a) {
        return a * a * a;
    }

    public double calc_volume(double l, double b, double h) { 
        return l * b * h;
    }

    public double calc_volume(double r, boolean sphere) {
        return (4.0 / 3.0) * 3.14 * r * r * r;
    }

    public double calc_volume(double r, double h, String shape) { 
        if (shape.equals("cylinder")) {
            return 3.14 * r * r * h;
        }

        if (shape.equals("cone")) {
            return (1.0 / 3.0) * 3.14 * r * r * h;
        }
        return 0;
    }
}

public class VolumeDemo {
    public static void main(String[] args) {
        Volume ob = new Volume();
        System.out.println("Volume of Cube(double) = " + ob.calc_volume(2));
        System.out.println("Volume of Cuboid(double) = " + ob.calc_volume(2, 3, 2));
        System.out.println("Volume of Sphere(double) = " + ob.calc_volume(1, true));
        System.out.println("Volume of Cylinder(double) = " + ob.calc_volume(1, 2.2, "cylinder"));
        System.out.println("Volume of Cone(double) = " + String.format("%.3f", ob.calc_volume(2.0, 3.2, "cone")));
    }
}