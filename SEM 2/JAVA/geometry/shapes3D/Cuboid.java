package geometry.shapes3D;
import geometry.shapes2D.Rectangle;

public class Cuboid extends Rectangle {
    public double height;
    
    public Cuboid(double l, double w, double h){
        super(l, w);
        height = h;
    }

    public double volume(){
        return area() * height;
    }

    @Override
    public String toString() {
        return "Cuboid(" + len + ", " + wid + ", " + height + ")";
   }
}