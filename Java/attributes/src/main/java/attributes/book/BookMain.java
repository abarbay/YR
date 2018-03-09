package attributes.book;



public class BookMain {
    public static void main(String[] args) {
        Book b1= new Book("Könyv");
        System.out.println(b1.getTitle());
        b1.setTitle("A Da Vinci Kód");
        System.out.println(b1.getTitle());
    }
}
