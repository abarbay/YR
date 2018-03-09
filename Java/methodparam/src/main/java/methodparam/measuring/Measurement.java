package methodparam.measuring;

public class Measurement {
   double [] values;

    public Measurement(double[] values) {
        this.values = values;
    }

    public int findFirstIndexInLimit(int lower, int upper){
        int result=-1;
        for (int i = 0; i <values.length ; i++) {
            if(values[i]>lower && values[i]<upper){
                result=i;
                break;
            }
        }
        return result;
    }

     public double minimum(){
        double result=Double.MAX_VALUE;
        for (int i = 0; i <values.length ; i++) {
            if(values[i]<result){
                result=values[i];
            }
        }
        return result;
    }

    public double maximum(){
        double result=Double.MIN_VALUE;
        for (int i = 0; i <values.length ; i++) {
            if(values[i]>result){
                result=values[i];
            }
        }
        return result;
    }

    public ExtremValues minmax(){
        return new ExtremValues(minimum(),maximum());

    }

}
