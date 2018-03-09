package enumtype.unit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {
    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target){
        BigDecimal result;
        result=new BigDecimal(source.getLENGTHINMILLIMETER()).multiply(length) ;
        result=result.divide(new BigDecimal(target.getLENGTHINMILLIMETER()));
        return result.setScale(4,BigDecimal.ROUND_HALF_UP);
    }

    public List<LengthUnit> siUnits(){
        List<LengthUnit> result= new ArrayList<>();
        for(LengthUnit unit: LengthUnit.values()){
            if(unit.isIS_SI()){
                result.add(unit);
            }

        }
        return result;
    }
}
