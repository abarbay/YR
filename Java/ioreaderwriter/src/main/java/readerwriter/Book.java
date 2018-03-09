package readerwriter;

public class Book {
    private long id;
    private String author;
    private String title;


    public Book(long id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id + ":" + author + ":" + title;
    }
}
