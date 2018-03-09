package dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {
    String word="";

    List<String> translations= new ArrayList<>();

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        addTranslation(translations);
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void addTranslation(List<String> newTranslations){
        for(String newTranslation:newTranslations) {
            if(!translations.contains(newTranslation)){
                translations.add(newTranslation);
            }
        }

    }

}
