package primitivetypes;

import com.sun.org.apache.xpath.internal.SourceTree;

public class PrimitiveTypesMain {

    public static void main(String[] args) {
        PrimitiveTypes p= new PrimitiveTypes();

        System.out.println("Pozitiv 35:"+ p.toBinaryString(35));
        System.out.println(p.toTwoComplementer(p.toBinaryString(35)));

    }


}
