package formatlocaleprintf;

import java.text.NumberFormat;
import java.util.Locale;

public class PrintFormat {

    public String printFormattedText(Double number){
        NumberFormat nf=NumberFormat.getCurrencyInstance(new Locale("hu","HU"));
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return String.format("Total is: %s", nf.format(number));

    }
    public String printFormattedText(int count, String fruit){
        return String.format("We counted %d %s in the basket", count, fruit);

    }
    public String printFormattedText(int number){
        return String.format("Right edge of numbers set at 4 spaces from text:%4d", number);

    }
    public String printFormattedText(Integer i, Integer j, Integer k){
        return String.format("Multiple objects containing text:%d\t%d\t%d", i,j,k);
    }

    public void formatMessageWithIntegerParameters(String formatString, Integer j, Integer k ){
        String findStr = "%d";
        int lastIndex = 0;
        int counter = 0;

        while(lastIndex != -1){

            lastIndex = formatString.indexOf(findStr,lastIndex);

            if(lastIndex != -1){
                counter ++;
                lastIndex += findStr.length();
            }
        }
        if(counter!=2){
            throw new IllegalArgumentException("Less objects then expected in format String!");
        }
    }
}
