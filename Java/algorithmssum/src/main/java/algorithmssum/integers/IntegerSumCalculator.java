package algorithmssum.integers;

import java.util.List;

public class IntegerSumCalculator {
    public int sum(List<Integer> numberCollection){
        int sum=0;
        for(int number:numberCollection){
            sum+=number;
        }
        return sum;
    }
}


