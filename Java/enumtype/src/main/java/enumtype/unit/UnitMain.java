package enumtype.unit;

import java.math.BigDecimal;
import java.util.Arrays;

public class UnitMain {
    public static void main(String[] args) {
        UnitConverter uc= new UnitConverter();

        System.out.println(uc.convert(new BigDecimal(1000),LengthUnit.CENTIMETER,LengthUnit.MILLIMETER));
        System.out.println(Arrays.asList(uc.siUnits()));
    }
}
