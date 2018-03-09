package dictionary;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<DictionaryItem> dictionaryItems= new ArrayList<>();



    public void addItem(String word, List<String> translations){
        if(dictionaryItems.size()!=0) {
            for(DictionaryItem item:dictionaryItems){
                if (item.getWord() != word) {
                    dictionaryItems.add(new DictionaryItem(word, translations));
                }
                else{
                    if(!item.getTranslations().contains(translations)){
                        item.addTranslation(translations);
                    }
                }
            }
        }
        else{ dictionaryItems.add(new DictionaryItem(word, translations));}
    }

    public List<String>findTranslations(String word){
        List<String> result=new ArrayList<>();
        for (DictionaryItem item: dictionaryItems){

            if( item.getWord()==word){
                result=item.getTranslations();
            }

        }
        return result;
    }
}
