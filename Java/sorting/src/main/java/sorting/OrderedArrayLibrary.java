package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {
    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] sortingById() {
        Arrays.sort(bookArray);
        return bookArray;
    }

    public Book[] sortingByTitle() {
        Arrays.sort(bookArray, Comparator.comparing(Book::getTitle));
        return bookArray;
    }
}
