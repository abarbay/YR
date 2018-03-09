package arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayMain {

    public String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public List<String> daysOfWeek(){
        String[] days={"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return Arrays.asList(days);
    }

    public void multiplicationTableAsString(int size){
        int[][] table= new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                table[i][j]=(i+1)*(j+1);
            }
        }
        System.out.println(Arrays.deepToString(table));
    }

    public boolean sameTempValues(double[] day, double[] anotherDay){
        return Arrays.equals(day,anotherDay);
    }

    public boolean wonLottery(int[] ticketNumber, int[] winningNumber){
            int [] tn=Arrays.copyOf(ticketNumber,ticketNumber.length);
            int [] wn=Arrays.copyOf(winningNumber,winningNumber.length);
            Arrays.sort(tn);
            Arrays.sort(wn);
            return Arrays.equals(tn,wn);
    }






    public static void main(String[] args) {
        ArrayMain am= new ArrayMain();
        System.out.println(am.numberOfDaysAsString());
        System.out.println(am.daysOfWeek());
        am.multiplicationTableAsString(5);
        double[] t1={1,2,3};
        double[] t2={1,2,3};
        int[] t3={1,2,3};
        int[] t4={2,1,3};
        System.out.println("Összehasonlit:"+am.sameTempValues(t1,t2));
        System.out.println("Lotto:"+am.wonLottery(t4,t3));
    }


}
