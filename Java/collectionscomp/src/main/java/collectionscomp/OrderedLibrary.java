package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {
    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle(){
        List<Book> result= new ArrayList<>(libraryBooks);
        Collections.sort(result, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return result;
    }
    public List<Book> orderedByAuthor(){
        List<Book> result= new ArrayList<>(libraryBooks);
        Collections.sort(result, new AuthorComparator());
        return result;
    }

    public List<String> orderedByTitleLocale(Locale locale){
        List<Book> books= new ArrayList<>(libraryBooks);
        List<String>result=new ArrayList<>();
        for(Book book:books){
            result.add(book.getTitle());
        }
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(Collator.PRIMARY);
        Collections.sort(result,collator);
        return result;
    }
}

