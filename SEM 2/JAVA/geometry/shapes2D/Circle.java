package geometry.shapes2D;
import geometry.interfaces.*;

public class Circle implements calcArea, calcPerimeter {
    public double radius;

    public Circle(double r){
        radius = r;
    }

    public double area(){
        return Math.PI * radius * radius;
    }
    
    public double perimeter(){
        return 2 * Math.PI * radius;
    }

    public String toString(){
        return "Circle(" + radius + ")";
    }
}