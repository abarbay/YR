package typeconversion.dataloss;

public class DataLoss {
    long l=(long)Float.MAX_VALUE+1;
    int count=0;

    public void DataLoss(){

            System.out.println(Float.MAX_VALUE);
            System.out.println(Float.(long)(Float.MAX_VALUE));
            System.out.println((float) l);
            System.out.println(Float.(long)(float) l);



    }

    public static void main(String[] args) {
        DataLoss dl=new DataLoss();

        dl.DataLoss();
    }


}
