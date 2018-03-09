package records;

public class Mark {
    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        if (tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        } else if (subject == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        } else {
            this.markType = markType;
            this.subject = subject;
            this.tutor = tutor;
        }

    }

    public Mark(String markType, Subject subject, Tutor tutor) {

    }


    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return markType.getDESCRIPTION() + "(" + markType.getVALUE() + ")";
    }
}
