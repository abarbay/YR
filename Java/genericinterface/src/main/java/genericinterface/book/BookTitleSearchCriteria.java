package genericinterface.book;

import genericinterface.Item;
import genericinterface.SearchCriteria;

public class BookTitleSearchCriteria implements SearchCriteria {
    private String title;

    public BookTitleSearchCriteria(String title) {
        this.title = title;
    }


    @Override
    public boolean pass(Item target) {
        Book book=(Book) target;
        return book.getTitle().equals(title);
    }
}
