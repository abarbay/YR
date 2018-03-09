package pi;

import java.math.BigDecimal;

public class PiGenerator {

    public BigDecimal getPi() {
        String vers= "Nem a régi s durva közelítés Mi szótól szóig így kijön Betűiket számlálva Ludolph eredménye már Ha itt végezzük húsz jegyen De rendre kijő még tíz pontosan Azt is bízvást ígérhetem ";
        String result="";
        int count=0;
        int sum=0;
        int wordcount=0;
        for (int i = 0; i <vers.length() ; i++) {

            if(Character.isLetter(vers.charAt(i))){
                count++;
                sum+=count;
                count=0;

            }
             else if(!Character.isLetter(vers.charAt(i))) {
                result=result+(int)sum;
                sum=0;

                wordcount++;
                if(wordcount==1){
                }
            }
            result=result+".";

        }
       return new BigDecimal(result);
    }
}
