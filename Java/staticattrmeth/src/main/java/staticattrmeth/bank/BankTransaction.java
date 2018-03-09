package staticattrmeth.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankTransaction {
    private final static int MIN_VALUE=0;
    private final static int MAX_VALUE=10000000;


    public static long currentMinValue=0L;
    public static long currentMaxValue=0L;
    public static long sumOfTrxs;
    public static int transactionCount=0;



    public BankTransaction(long input) {
        if(input<MIN_VALUE  || input>MAX_VALUE){
            throw new IllegalArgumentException("The input value is not between 1 and 10000000");
        }
        else{
            if(input<currentMinValue || transactionCount==0){
                currentMinValue= input;
            }
            if(input>currentMaxValue || transactionCount==0){
                currentMaxValue=  input;
            }
        }
        sumOfTrxs+= input;
        transactionCount++;

    }

    public static void initTheDay(){
        currentMaxValue=0L;
        currentMinValue=0L;
        sumOfTrxs=0;
        transactionCount=0;
    }



    public static BigDecimal averageOfTransaction(){
        return new BigDecimal(sumOfTrxs/transactionCount);
    }

    public static long getCurrentMinValue(){
        return currentMinValue;
    }

    public static long getCurrentMaxValue(){
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs(){
        return new BigDecimal(sumOfTrxs) ;
    }



}
