import java.util.ArrayList;
import java.util.List;

public class Books {
    List<String> books = new ArrayList<>();

    public void add(String book) {
        books.add(book);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        for (String book : books) {
            if (book.contains(prefix)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<String> getTitles() {
        return books;
    }

    // Bónusz
    public void removeByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        for (String book : books) {
            if (book.contains(prefix)) {
                result.add(book);
            }
        }
        //Ha egyesével akarnám törölni nem lehetséges mert megváltozik a ciklus közben a méret és emiatt hibára fut
        // Megoldás kigyüjteni az összes egyezőséget egy ArrayListbe és utána futtatni a removeAll metódust.
        books.removeAll(result);
    }
}
