class Area {
    public int calc_area(int a) {
        return a * a;
    }

    public double calc_area(double a) {
        return a * a;
    }

    public int calc_area(int l, int b) {
        return l * b;
    }

    public double calc_area(double l, double b) {
        return l * b;
    }

    public double calc_area(double r, boolean circle) {
        return 3.14 * r * r;
    }

    public double calc_area(double b, double h, boolean triangle) {
        return 0.5 * b * h;
    }
}

public class AreaDemo {
    public static void main(String[] args) {
        Area ob = new Area();
        System.out.println("Area of Square(int) = " + ob.calc_area(5));
        System.out.println("Area of Square(double) = " + ob.calc_area(5.5));
        System.out.println("Area of Rectangle(int) = " + ob.calc_area(2, 3));
        System.out.println("Area of Rectangle(double) = " + ob.calc_area(2.3, 4.0));
        System.out.println("Area of Circle(double) = " + ob.calc_area(1, true));
        System.out.println("Area of Triangle(double) = " + ob.calc_area(2.0, 3.2, true));
    }
}

/*
Sample Input/Output:

Area of Square(int) = 25
Area of Square(double) = 30.25
Area of Rectangle(int) = 6
Area of Rectangle(double) = 9.2
Area of Circle(double) = 3.14
Area of Triangle(double) = 3.2
 */