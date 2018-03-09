package bigdecimal;


import java.util.ArrayList;
import java.util.List;

public class BigDecimal {
    final int DEFAULT_SCALE=2;
    final java.math.BigDecimal TAX= new java.math.BigDecimal(0.27);


    public java.math.BigDecimal calculateTax(java.math.BigDecimal price){
        return price.multiply(TAX).setScale(DEFAULT_SCALE, java.math.BigDecimal.ROUND_HALF_UP);
    }

    public java.math.BigDecimal calculatePriceWithTax(java.math.BigDecimal price){
        return price.add(price.multiply(TAX).setScale(DEFAULT_SCALE, java.math.BigDecimal.ROUND_HALF_UP));
    }

    public java.math.BigDecimal distributeBetweenDays(java.math.BigDecimal price, int numberOfDays){
        return price.divide(new java.math.BigDecimal(numberOfDays)).setScale(DEFAULT_SCALE, java.math.BigDecimal.ROUND_CEILING);
    }

//    public  List<double> roundHalfUpAndAddToLast(List<BigDecimal> numbers, int scale){
//        List<BigDecimal> result =new ArrayList<>();
//        for (number:numbers){
//            result.add(new java.math.BigDecimal(number)).setScale(DEFAULT_SCALE, java.math.BigDecimal.ROUND_HALF_UP);
//
//        }
//
//    }


}
