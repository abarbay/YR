package finalmodifier;

import finalmodifier.CircleCalculator;
import finalmodifier.Gentleman;


public class PiMain {

    public static void main(String[] args) {
        Gentleman man = new Gentleman();
        CircleCalculator c= new CircleCalculator();
        CylinderCalculator c2=new CylinderCalculator();
        TaxCalculator t= new TaxCalculator();
        CylinderCalculatorBasedOnCircle c3 = new CylinderCalculatorBasedOnCircle();

        System.out.println(man.sayHello("Adam"));
        System.out.println("Kör kerület:"+c.calculatePerimeter(10));
        System.out.println("Kör terület:"+c.calculateArea(5));
        System.out.println("Henger felszine:"+c2.calculateSurfaceArea(5,10));
        System.out.println("Henger térfogata:"+c2.calculateVolume(5,10));
        System.out.println(CircleCalculator.PI);
        System.out.println(t.tax(1000));
        System.out.println(t.priceWithTax(1000));
        System.out.println("Henger felszine2:"+c3.calculateSurfaceArea(5,10));
        System.out.println("Henger térfogata2:"+c3.calculateVolume(5,10));


    }
}
