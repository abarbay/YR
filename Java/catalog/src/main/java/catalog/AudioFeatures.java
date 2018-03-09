package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {
    private String title;
    private int length;
    private List<String> composer = new ArrayList<>();
    private List<String> performers = new ArrayList<>();

    public AudioFeatures(String title, int length, List<String> performers) {
        if (title == null || title.equals("")) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length < 1) {
            throw new IllegalArgumentException();
        }
        if (performers == null || performers.equals("")) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        if (title == null || title.equals("")) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length < 1) {
            throw new IllegalArgumentException();
        }
        if (performers == null || performers.equals("")) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = composer;

    }

    public List<String> getComposer() {
        return composer;
    }

    public List<String> getPerformers() {
        return performers;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getContributors() {
        List<String> result = new ArrayList<>();
        for (String composer : this.getComposer()) {
            result.add(composer);
        }
        for (String performer : this.getPerformers()) {
            if (!(result.contains(performer))) {
                result.add(performer);
            }

        }
        return result;
    }
}
