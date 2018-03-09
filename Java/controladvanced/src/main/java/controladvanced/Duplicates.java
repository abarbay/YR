package controladvanced;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {
    public List<Integer> find(List<Integer> firstList){
        List<Integer> result=new ArrayList<>();

        for (int i = 0; i <firstList.size() ; i++) {

            for (int j = i+1; j <firstList.size() ; j++) {
                int f1=firstList.get(i);
                int f2=firstList.get(j);
                if(firstList.get(i)==firstList.get(j)){

                            result.add(firstList.get(j));
                            break;
                }

            }

            
        }
        return result;
    }
}
