package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectMain {
    public static void main(String[] args) {
        System.out.println(new Book());
        Book emptyBook = null;
        System.out.println(emptyBook);
        Book book = new Book();
        System.out.println(book);
        book = null;
        System.out.println(book);
        book = new Book();
        System.out.println(book);
        Book anotherBook = new Book();
        System.out.println(book == anotherBook);
        anotherBook = book;
        System.out.println(book = anotherBook);
        System.out.println(anotherBook instanceof Book);

        Book[] books={new Book(),new Book(),new Book()};
        List<Book>bookLst1= Arrays.asList(new Book(),new Book(),new Book());
        List<Book> bookLst2= new ArrayList<>();
        bookLst2.add(new Book());
        bookLst2.add(new Book());
        bookLst2.add(new Book());


    }
}
