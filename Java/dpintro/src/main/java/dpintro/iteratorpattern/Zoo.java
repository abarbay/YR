package dpintro.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

public class Zoo implements Container {
    List<Animal> animals = new ArrayList<>();

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public Iterator getIterator() {
        return new ZooIterator(animals);
    }
}
