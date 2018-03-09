package searching;


import java.util.Arrays;

public class BookArraySearch {
    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title){
        if(author.isEmpty()|| title.isEmpty()){throw new IllegalArgumentException("Author or title must not be empty!");}
        int result=Arrays.binarySearch(bookArray,new Book(author,title));
        if (result<0){
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
        else{
            return bookArray[result];
        }

    }
}
