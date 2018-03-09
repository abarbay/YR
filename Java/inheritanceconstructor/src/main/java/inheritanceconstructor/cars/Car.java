package inheritanceconstructor.cars;

public class Car {
    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (fuel>tankCapacity){throw new IllegalArgumentException("Tank capacity is less than fuel!");}
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void modifyFuelAmount(double fuel){
        this.fuel=fuel+getFuel();
    }

    public void drive(int km){
        double mileage=0.0;
        mileage=((fuelRate/100)*km);
        if(this.fuel-mileage<0){throw new RuntimeException("Not enough fuel available!");}
        else{
            this.fuel=this.fuel-mileage;
        }

    }

    public double calculateRefillAmount(){
        return tankCapacity-this.getFuel();
    }

}
