package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix="Hello";
        String name="John Doe";
        String message= prefix+ " "+name;
        message=message+444;
        Boolean b= message.equals("Hello John Doe") ? true :false;
        Boolean c= message.equals("Hello John Doe444") ? true :false;
        String x=""+"";
        String abc="Abcde";

        System.out.println(b);
        System.out.println(c);
        System.out.println(x.length());
        System.out.println(abc.length()+","+abc.charAt(0)+","+abc.charAt(2)+","+abc.substring(0,3));
    }
}
