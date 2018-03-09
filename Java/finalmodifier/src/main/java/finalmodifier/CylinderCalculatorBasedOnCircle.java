package finalmodifier;

public class CylinderCalculatorBasedOnCircle {
    CircleCalculator c = new CircleCalculator();

    public double calculateVolume(double r, double h){
        return c.calculateArea(r)*h;

    }

    public double calculateSurfaceArea(double r, double h){
        return 2*(CircleCalculator.PI*r*h)+2*c.calculateArea(r);
    }
}
