import java.time.Duration;
import java.time.LocalDateTime;

public class ProjectItem {
    private Project project;
    private Employee participant;
    private LocalDateTime from;
    private LocalDateTime to;

    public ProjectItem(Project project, LocalDateTime from, LocalDateTime to, Employee participant) {
        this.project = project;
        this.participant = participant;
        this.from = from;
        this.to = to;
    }


    public Project getProject() {
        return project;
    }

    public Employee getParticipant() {
        return participant;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public Duration workHours() {
        return Duration.between(from, to);
    }
}

