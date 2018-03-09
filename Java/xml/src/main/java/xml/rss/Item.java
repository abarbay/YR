package xml.rss;

public class Item {
    private String title;
    private String description;
    private String link;

    public Item(String title, String link, String description) {
        this.title = title;
        this.description = description;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }
}
