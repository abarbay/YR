package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {
    private String name;
    private LocalDateTime time;
    private Status status;
    private List<Comment> comments = new ArrayList<>();

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
    }

    public Issue(Issue issue, CopyMode mode) {
        this.name = issue.name;
        this.time = issue.time;
        this.status = issue.status;
        if (mode.equals(CopyMode.WITH_COMMENTS)) {
            this.comments = cloneComment(issue.comments);
        }
    }

    // klónozom a commenteket is abban az esetben ha van már bejegyzett comment
    private static List<Comment> cloneComment(List<Comment> commentsList) {
        List<Comment> result = new ArrayList<>();
        for (Comment c : commentsList) {
            result.add(new Comment(c));
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComments() {
        return comments;
    }


}
