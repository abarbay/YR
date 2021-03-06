package inheritanceconstructor.classroom;

public class Course {

    private int participants;
    private Facility facility;

    public Course(int participants, Facility facility) {
        this.participants = participants;
        this.facility = facility;
    }

    public int getParticipants() {
        return participants;
    }

    public Facility getFacilityNeeded() {
        return facility;
    }
}
