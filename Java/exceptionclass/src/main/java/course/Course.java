package course;

public class Course {
    private String name;
    private SimpleTime begin;


    public Course(String name, SimpleTime begin) {
        if(begin==null || name==null ){throw new IllegalArgumentException();}
        this.name = name;
        this.begin = begin;
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }


    @Override
    public String toString() {
        return String.format("%s: %s", begin, name);
    }
}
