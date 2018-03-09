package collectionstreeset;


import java.util.Set;
import java.util.TreeSet;

public class WordFilter {
    public Set<String> filterWords(String[] randomStrings){
        Set<String> uniqueWords= new TreeSet<>();
        for (String string:randomStrings){
            uniqueWords.add(string);
        }
        return uniqueWords;
    }
}
