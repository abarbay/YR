package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class Autoboxing {

    public List<Integer> createList(int... numbers) {
        List<Integer> list = new ArrayList<>();
        for (Integer number : numbers) {
            list.add(number);
        }
        return list;
    }

    public int sumIntegerList(List<Integer> integerList) {
        int sum = 0;
        for (Integer number : integerList) {
            sum += number;
        }
        return sum;
    }

    public int sumIntegerObjects(Integer... integers) {
        int sum = 0;
        for (Integer number : integers) {
            if (number instanceof Integer) {
                sum += number;
            }
        }
        return sum;

    }
}
