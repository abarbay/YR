package formatlocalebundle;


import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Translator {

    public String englishToHungarian(String key){
        Locale locale = new Locale("hu");
        ResourceBundle rb = ResourceBundle.getBundle("window", locale);
        try {
            return rb.getString(key);
        }catch(MissingResourceException e){
            throw new IllegalArgumentException("Key not found");
        }

    }
    public String englishToGerman(String key){
        Locale locale = new Locale("de");
        ResourceBundle rb = ResourceBundle.getBundle("window", locale);
        try {
            return rb.getString(key);
        }catch(MissingResourceException e){
            throw new IllegalArgumentException("Key not found");
        }
    }
}
