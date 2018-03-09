import java.util.ArrayList;
import java.util.List;

public class Metszet {



    public List<Integer> szamol(int [] tomb ,int aOszto, int bOszto){
        if(tomb==null){throw new IllegalArgumentException("A tömb értéke nem lehet üres;");}
        if(aOszto==0 || bOszto==0 ){throw new ArithmeticException("A nullval való osztás nem engedélyezett");}
        List<Integer> result= new ArrayList<Integer>();
        for(int item:tomb){
            if(item%aOszto==0 && item%bOszto==0){
             result.add(item);
            }
        }
        return result;

    }

}
