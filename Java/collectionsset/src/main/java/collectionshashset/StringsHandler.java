package collectionshashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection){
        Set<String> result= new HashSet<>(stringCollection);
        return result;
        }


    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB){
        Set<String> result= new HashSet<>();
        for(String item:setA){
              if(setB.contains(item)) {
                  result.add(item);
              }
        }
        return result;
    }

}
