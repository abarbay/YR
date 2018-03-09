package catalog;

import java.util.List;

public class PrintedFeatures implements Feature {
    private List<String> authors;
    private int numberOfPages;
    private String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (title == null || title.equals(""))
            throw new IllegalArgumentException("Empty title");
        if (numberOfPages < 1)
            throw new IllegalArgumentException();
        if (authors == null || authors.equals(""))
            throw new IllegalArgumentException();
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    public List<String> getContributors() {
        return authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getTitle() {
        return title;
    }
}
