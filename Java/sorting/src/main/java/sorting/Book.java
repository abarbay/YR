package sorting;

public class Book implements Comparable<Book> {
    private int id;
    private String author;
    private String title;


    public Book(int id, String author, String title) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Book o) {
        if (o.getId() > this.getId()) {
            return -1;
        } else if (o.getId() < this.getId()) {
            return 1;
        } else {
            return 0;
        }
    }
}
