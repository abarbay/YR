package dpintro.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

public class ZooIterator implements Iterator {
    private int index;
    private List<Animal> animalList = new ArrayList<>();

    public ZooIterator(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public boolean hasNext() {
        return (index < animalList.size());
    }

    @Override
    public Object next() {
        Object nextAnimal = animalList.get(index);
        index++;
        return nextAnimal;
    }
}
