package packages.numbers;

import packages.strings.StringConcatenator;

public class NumberConcatenator {

    public String concatenate(int a, int b) {

        StringConcatenator sc = new StringConcatenator();
        return sc.concatenate(Integer.toString(a), Integer.toString(b));
    }
}
