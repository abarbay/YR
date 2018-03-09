package collectionsequalshash;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {


    public Book findBookByTitleAuthor(List<Book> books, String title, String author){
        Book result=null;
        for(Book book:books){
            if(book.getTitle().equals(title)&&book.getAuthor().equals(author)){
                result=book;

            }
        }
        return result;
    }

    public Book findBook(List<Book> books, Book book){
        Book result=null;
        for(Book item:books){
            if(item.equals(book)){
                result=book;
                break;
            }
        }
        return result;

    }


    public Set<Book> addBooksToSet(Book[] books){
        Set<Book> booksSet= new HashSet<>(Arrays.asList(books));
        return booksSet;
    }
}
