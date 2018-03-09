package operators;



public class Operators {

    private static final int BIN = 0b01010101010101010101010101010101;

    public boolean isEven(int n){
       return (n%2 == 0)? true: false;
    }

    public int flipEvenBits(int i){


        return (i ^ BIN);

    }



}
