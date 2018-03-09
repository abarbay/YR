package inheritanceconstructor.cars;

public class Jeep extends Car {
    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    public void drive(int km){
        double mileage=0.0;
        mileage=((super.getFuelRate()/100)*km);
        if(extraFuel>=mileage){ this.extraFuel=this.extraFuel-mileage;}
        else{
            mileage=mileage-this.extraFuel;
            this.extraFuel=0;
        }
        if(super.getFuel()-mileage<0){throw new RuntimeException("Not enough fuel available!");}
        else{
            this.setFuel(this.getFuel()-mileage);
        }
    }

    public double calculateRefillAmount(){
        return (super.getTankCapacity()+this.extraCapacity)-(super.getFuel()+this.extraFuel);
    }
}
