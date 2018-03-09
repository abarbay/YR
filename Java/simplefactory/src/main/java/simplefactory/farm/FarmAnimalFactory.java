package simplefactory.farm;

public class FarmAnimalFactory implements AnimalFactory {

    @Override
    public Animal create(String animalType) {
        if (animalType == null || animalType == "") {
            throw new IllegalArgumentException("Animal type must not be empty!");
        }
        switch (animalType) {
            case "cock":
                return new Cock();
            case "frog":
                return new Frog();
            case "horse":
                return new Horse();
            default:
                throw new IllegalArgumentException("Unrecognizable animal type!");
        }
    }
}
