package algorithmsdecision.integers;

import java.util.List;

public class IntegerDecisionMaker {
    public boolean containsGreaterThan(List<Integer> list, int value){
        Boolean result=false;
            for(Integer item:list){
                if(item>value){
                    result=true;
                    break;
                }
            }
            return result;
    }

    public boolean containsLowerThan(List<Integer> list, int value){
        Boolean result=false;
        for(Integer item:list){
            if(item<value){
                result=true;
                break;
            }
        }
        return result;
    }

}
