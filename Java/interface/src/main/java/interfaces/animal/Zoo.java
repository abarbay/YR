package interfaces.animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo implements Animal {
   List<Animal> animals=new ArrayList<>();

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String getName() {
        return null;
    }

    public int getNumberOfAnimals(){
        return animals.size();
    }

    public int getNumberOfLegs(){
        int result=0;
        for(Animal animal:animals){
            result+=animal.getNumberOfLegs();
        }
        return result;
    }

}
