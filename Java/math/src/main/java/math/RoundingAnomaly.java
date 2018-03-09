package math;

import java.util.Arrays;
import java.util.Random;

public class RoundingAnomaly {
    /**
     *
     * @param size A tömb mérete
     * @param max A tömb összegének maximális értéke
     * @param scale A tizedesjegyek száma
     * @return Size elem számú tömb melynek az összesített értéke max
     */
    double[] randomNumbers(int size, double max, int scale){
        Random rnd= new Random();
        double[] arr= new double[size];

        for(int i=0;i<size;i++){
          arr[i]=Math.round(rnd.nextDouble()*max*Math.pow(10,scale))/Math.pow(10,scale);
        }
        return arr;
    }

       double roundAfterSum(double[] numbers){
            double result=0.0;
            for(int i=0;i<numbers.length;i++){
                result+=numbers[i];
            }
            return Math.round(result);
    }

    double sumAfterRound(double[] numbers){
        double result=0.0;
        for(int i=0;i<numbers.length;i++){
            result+=Math.floor(numbers[i]);
        }
        return result;
    }

    double difference(int size, double max, int scale){
        double[] arr=randomNumbers(size,max,scale);
        double round1=roundAfterSum(arr);
        double round2=sumAfterRound(arr);
        return round1-round2;
    }

    public static void main(String[] args) {
        RoundingAnomaly ra=new RoundingAnomaly();
        double avg=0;

        for(int i=0;i<100;i++){
            avg+=ra.difference(1000,1_000_000,5);
        }
        avg/=100;
        System.out.println(avg);
    }

}
