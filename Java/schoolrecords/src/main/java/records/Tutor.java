package records;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taughtSubjects = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(Subject teachingSubject) {
        Boolean result = false;
        for (Subject subject : taughtSubjects) {
            if (subject.equals(teachingSubject)) {
                result = true;
            }
        }
        return result;
    }

}
