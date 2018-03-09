package xml.rss;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String title;
    private String link;
    private String description;
    private List<Item> items= new ArrayList<>();

    public Channel(String title, String link, String description, List<Item> items) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }
}
