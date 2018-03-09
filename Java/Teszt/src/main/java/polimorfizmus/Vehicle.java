package polimorfizmus;

public abstract class Vehicle  {

    public abstract void forward(int distance);

    String ID= "Vehicle";

    public void fly(int height){
        System.out.println("Vehicle  flying height is:"+ height +" meter");
        System.out.println("Vehicle method");
    }
}
