package records;


import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if (name == "" || name == null) {
            throw new IllegalArgumentException("Student name must not be empty!");
        } else {
            this.name = name;
        }

    }

    public String getName() {
        return name;
    }



    public double calculateAverage() {
        double result = 0.0;
        double sum = 0.0;
        for (Mark mark : marks) {
            sum += mark.getMarkType().getVALUE();
        }
        if (marks.size() != 0) {
            result = sum / marks.size();
        }
        return Math.round(result * 100.0) / 100.0;

    }

    public double calculateSubjectAverage(Subject subject) {
        double result = 0.0;
        double sum = 0.0;
        int counter = 0;
        for (Mark mark : marks) {
            if (mark.getSubject().equals(subject)) {
                sum += mark.getMarkType().getVALUE();
                counter++;
            }
        }
        if (counter != 0) {
            result = sum / counter;
        }
        return result;

    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        } else {
            marks.add(mark);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (marks != null ? !marks.equals(student.marks) : student.marks != null) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public String toString() {
        String result = this.getName();
        for (Mark mark : marks) {
            result += " marks: " + mark.getSubject().getSubjectName() + ":";
            result += " " + mark.toString();
        }
        return result;
    }
}
