package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {
    private List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library = library;
    }

    public List<Book> createUnmodifiableLibrary(){
        return Collections.unmodifiableList(library);
    }
    public List<Book> reverseLibrary(){
        List<Book> reverseLibrary= new ArrayList<>(library);
        Collections.reverse(reverseLibrary);
        return reverseLibrary;
    }
    public Book getFirstBook(){
        Collections.sort(library);
        return library.get(0);
    }
    public Book getLastBook(){
        Collections.sort(library);
        Collections.reverse(library);
        return library.get(0);
    }
}
