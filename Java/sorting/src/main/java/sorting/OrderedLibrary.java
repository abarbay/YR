package sorting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class OrderedLibrary {
    private Set<Book> library;

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook() {
        if (library.size() == 0) {
            throw new NullPointerException("Libray is empty!");
        }
        List list = new ArrayList<>(library);
        Collections.sort(list);
        return (Book) list.get(0);

    }
}
