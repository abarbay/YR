package array;

import java.util.Arrays;

public class ArrayHandler {

    public int[] append(int[] source, int item){
        int[] appendArray= new int[source.length+1];
       System.arraycopy(source,0,appendArray,0,source.length);
       appendArray[source.length]=item;
       return appendArray;
    }

    public boolean contains(int[] source, int itemToFind){
        boolean result=false;
        for(int item:source){
            if (item==itemToFind){result=true;}
        }
        return result;
    }

    public int find(int[] source, int itemToFind){
        int index=-1;
        for(int i=0;i<source.length;i++)
            if(source[i]==itemToFind){
                index=i;
            }
        return index;
        }

    public int[] insert(int[] source, int index, int item){
        int[] insertIntoArray= new int[source.length+1];
        System.arraycopy(source,0,insertIntoArray,0,index);
        insertIntoArray[index]=item;
        System.arraycopy(source,index,insertIntoArray,index+1,source.length-index);
        return insertIntoArray;
    }

//    public int[] remove(int[] source, int index){
//        int[] removeArray= new int[source.length-1];
//        System.out.println(Arrays.toString(source));
//        System.arraycopy(source,0,removeArray,0,index);
//        System.arraycopy(source,index+1,removeArray,index,index);
//        System.out.println(Arrays.toString(removeArray));
//        return removeArray;
//    }


    public static void main(String[] args) {

        ArrayHandler a1=new ArrayHandler();

        int[] testArray={1,2,3,4};
        int[] testArray2= new int[4];
        int[] testArray3= new int[5];
        int[] testArray4= new int[3];

        testArray2=a1.append(testArray,5);
        System.out.println("new appended item:"+ testArray2[4]);
        System.out.println(Arrays.toString(testArray));
        System.out.println(Arrays.toString(testArray2));
        System.out.println("Contains:"+a1.contains(testArray,9));
        System.out.println("FindIndex:"+ a1.find(testArray,2));
        testArray3=a1.insert(testArray,2,99);
        System.out.println(Arrays.toString(testArray));
        System.out.println("new inserted item:"+ testArray3[2]);
        System.out.println(Arrays.toString(testArray3));
        //testArray4=a1.remove(testArray,2);




    }
}
