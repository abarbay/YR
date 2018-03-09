package arrayofarrays;

import java.time.LocalDate;
import java.util.Arrays;



public class ArrayOfArrayMain {

    public int[][] multiplicationTable(int size){
        int[][] multiplicationArray= new int[size][size];

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                multiplicationArray[i][j] = (i+1) * (j+1);
            }

        }
        return multiplicationArray;
    }

    public void printArrayOfArrays(int[][] a){
        int[][] printArray = a;

        for(int i=0;i<printArray.length;i++){
            System.out.println(Arrays.toString(printArray[i]));
        }
    }

    public int[][] triangularMatrix(int size){
        int[][] triangularArray= new int [size][];
        for(int i=0;i<size;i++){
            triangularArray[i]= new int[i+1];
            for(int j=0;j<i+1;j++){
                triangularArray[i][j]= i;
            }
        }
        return triangularArray;
    }

   public int[][] getValues(){
       int[][] monthArray= new int [12][];
       for (int i=0;i<12;i++){
           LocalDate date=LocalDate.of(2017,i+1,1);
           int monthLength=date.lengthOfMonth();
           monthArray[i]= new int[monthLength];
           for(int j=1;j<monthLength+1;j++){

               monthArray[i][j-1]=0;
           }
       }
       return monthArray;
   }
}

