import arrayofarrays.ArrayOfArrayMain;



import java.util.Arrays;



public class MainTest {
    public static void main(String[] args) {

        ArrayOfArrayMain aa=new ArrayOfArrayMain();
        System.out.println("Tömbök tömbje");
        System.out.println(Arrays.deepToString(aa.multiplicationTable(5)));
        System.out.println("Szorzótábla");
        aa.printArrayOfArrays(aa.multiplicationTable(5));
        System.out.println();
        System.out.println("Háromszög:");
        aa.printArrayOfArrays((aa.triangularMatrix(7)));
        System.out.println("Hónapok:");
        aa.printArrayOfArrays(aa.getValues());

    }
}
