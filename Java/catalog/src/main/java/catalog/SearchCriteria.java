package catalog;

public class SearchCriteria {
    public String contributor;
    public String title;

    private SearchCriteria(String contributor, String title) {
        this.contributor = contributor;
        this.title = title;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (contributor == null || contributor.equals("")) {
            throw new IllegalArgumentException();
        }
        if (title == null || title.equals("")) {
            throw new IllegalArgumentException();
        }
        return new SearchCriteria(contributor, title);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (contributor == null || contributor.equals("")) {
            throw new IllegalArgumentException();
        }
        return new SearchCriteria(contributor, null);


    }

    public static SearchCriteria createByTitle(String title) {
        if (title == null || title.equals("")) {
            throw new IllegalArgumentException();
        }
        return new SearchCriteria(null, title);

    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasContributor() {
        return (this.contributor != null);
    }

    public boolean hasTitle() {
        return (this.title != null);

    }


}
