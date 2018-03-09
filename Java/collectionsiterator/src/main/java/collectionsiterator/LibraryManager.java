package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {
    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        for (Iterator<Book> i = libraryBooks.iterator(); i.hasNext(); ) {
            Book book = i.next();
            if (book.getRegNumber() == regNumber) {
                return book;
            }
        }
        throw new MissingBookException("No books found with regnumber:");

    }

    public int removeBookByRegNumber(int regNumber) {
        for (Iterator<Book> i = libraryBooks.iterator(); i.hasNext(); ) {
            Book book = i.next();

            if (book.getRegNumber() == regNumber) {
                libraryBooks.remove(book);
                return book.getRegNumber();
            }

        }
        throw new MissingBookException("No books found with regnumber:");

    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> bookResult = new HashSet<>();
        for (Iterator<Book> i = libraryBooks.iterator(); i.hasNext(); ) {
            Book book = i.next();

            if (book.getAuthor().equals(author)) {
                bookResult.add(book);
            }

        }
        if (bookResult.size() == 0) {
            throw new MissingBookException("No books found by");
        } else {
            return bookResult;
        }
    }

    public int libraryBooksCount() {
        int sum = 0;
        for (Iterator<Book> i = libraryBooks.iterator(); i.hasNext(); ) {
            i.next();
            sum++;
        }
        return sum;
    }

}
