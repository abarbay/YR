package virtualmethod.vehicle;


public class FerryBoat extends Vehicle {
    private final int MAX_CARRY_WEIGHT;
    private Car car;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
        this.MAX_CARRY_WEIGHT = vehicleWeight;
    }

    @Override
    public int getVehicleWeight() {
        return super.getVehicleWeight();
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + this.car.getVehicleWeight() + PERSON_AVERAGE_WEIGHT;
    }

    public boolean canCarry(Car car) {
        boolean result = false;
        if (car.getVehicleWeight() < MAX_CARRY_WEIGHT) {
            result = true;
        }
        return result;
    }

    public boolean load(Car car) {
        boolean result = false;
        if (canCarry(car)) {
            this.car = car;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "FerryBoat{" +
                "car=" + car +
                '}';
    }
}
