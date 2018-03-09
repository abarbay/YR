package bigdecimal;

public class BigDecimalMain {

    public static void main(String[] args) {
        BigDecimal bd=new BigDecimal();

        System.out.println(bd.calculateTax(new java.math.BigDecimal(1000)));
        System.out.println(bd.calculatePriceWithTax(new java.math.BigDecimal((1000))));
        System.out.println(bd.distributeBetweenDays(new java.math.BigDecimal(1000),5));

        String s="banana";

        System.out.println(s.indexOf('a'));

    }

}