package geometry.shapes3D;
import geometry.shapes2D.Circle;

public class Sphere extends Circle {
    public Sphere(double r){
        super(r);
    }

    public double volume(){
        return (4/3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString() {
        return "Sphere(" + radius + ")";
   }
}