package exceptionresource.accesscontrol;

import java.time.LocalDateTime;

public class Log {
    private LocalDateTime time;
    private String id;
    private Enum AccessType;

    public Log(LocalDateTime time, String id, Enum accessType) {
        this.time = time;
        this.id = id;
        this.AccessType = accessType;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getId() {
        return id;
    }

    public Enum getAccessType() {
        return AccessType;
    }
}
