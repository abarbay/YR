package dpintro.reptile;

public class Crocodile extends LandDweller implements CanSwim {

    public Crocodile(int energy) {
        super(energy);
    }

    @Override
    public void swim() {
        if (this.getEnergy() < 5) {
            throw new IllegalArgumentException("Not enough energy to move!");
        }
        decreaseEnergy(5);
    }

    public void walk() {
        if (this.getEnergy() < 20) {
            throw new IllegalArgumentException("Not enough energy to move!");
        }
        decreaseEnergy(20);
    }

    @Override
    protected void decreaseEnergy(int value) {
        super.decreaseEnergy(value);
    }

    @Override
    public int getEnergy() {
        return super.getEnergy();
    }
}
