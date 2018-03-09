package classstructure;

public class Book {
    private String author;
    private String adress;
    private String regNumber;

    public Book(String author, String adress) {
        this.author = author;
        this.adress = adress;

    }

    public String getAuthor() {
        return author;
    }

    public String getAdress() {
        return adress;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void register(String regNumber) {
        this.regNumber = regNumber;
    }
}
