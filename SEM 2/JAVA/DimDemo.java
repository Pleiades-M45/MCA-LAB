interface Dim {
    double area(int x);
}

class DimDemo {
    public static void main(String[] args){
        Dim square = (x) -> x * x;
        Dim cube = (x) -> 6 * (x * x);
        Dim circle = (x) -> Math.PI * (x * x);
        Dim sphere = (x) -> 4 * Math.PI * (x * x);

        System.out.println("Area of Square = " + square.area(2));
        System.out.println("Surface Area of Cube = " + cube.area(2));
        System.out.println("Area of Circle = " + circle.area(2));
        System.out.println("Surface Area of Sphere = " + sphere.area(2));
    }
}

/*
Sample Input/Output:

Area of Square = 4.0
Surface Area of Cube = 24.0
Area of Circle = 12.566370614359172
Surface Area of Sphere = 50.26548245743669
*/