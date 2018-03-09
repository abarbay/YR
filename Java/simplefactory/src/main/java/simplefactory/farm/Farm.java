package simplefactory.farm;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private AnimalFactory animalFactory;
    private List<Animal> animals = new ArrayList<>();

    public Farm(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;
    }

    public void newAnimalArrived(String animalType) {
        if (animalType == null || animalType == "") {
            throw new IllegalArgumentException("Animal type must not be empty!");
        }
        animals.add(animalFactory.create(animalType));
    }

    public List<String> getAnimalVoices() {
        List<String> result = new ArrayList<>();
        for (Animal animal : animals) {
            if (!result.contains(animal.speak().toString())) {
                result.add(animal.speak().toString());
            }
        }
        return result;
    }

}

