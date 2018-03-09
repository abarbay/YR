package dpintro.reptile;

public abstract class LandDweller {
    private int energy;

    public LandDweller(int energy) {
        this.energy = energy;
    }

    protected void decreaseEnergy(int value) {
        energy = energy - value;


    }

    public int getEnergy() {
        return energy;
    }
}
