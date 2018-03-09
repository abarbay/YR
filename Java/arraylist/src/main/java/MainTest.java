import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
       Capsules capsules= new Capsules();
       Books books= new Books();
       List<String> storage= new ArrayList<>();

       capsules.addFirst("Kék");
       capsules.addFirst("Zöld");

       System.out.println("Zöld és Kék:"+capsules.getColors());

       capsules.addLast("Sárga");
       capsules.addFirst("Piros");

       System.out.println("Piros,Zöld,Kék,Sárga:"+capsules.getColors());
       capsules.removeFirst();
       System.out.println("Zöld,Kék,Sárga:"+capsules.getColors());
       capsules.removeLast();
       System.out.println("Zöld,Kék:"+capsules.getColors());
       capsules.removeLast();
       System.out.println("Zöld:"+capsules.getColors());

       //Bónusz

       storage=capsules.getColors();
       // clear metódus nem clean!!!
       storage.clear();
        System.out.println("Capsules a storage.clear metódus után:"+capsules.getColors());
        System.out.println("Storage:"+storage.toString());

       books.add("Első könyv");
       books.add("Második könyv");
       books.add("Harmadik regény");
       System.out.println(" Három iromány:"+books.getTitles());
       System.out.println("Csak a könyvek:"+ books.findAllByPrefix("könyv"));
       books.removeByPrefix("kö");
        System.out.println("Books List a removeByPrefix metódus után"+books.getTitles());

    }
}
