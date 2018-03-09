package records;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rnd;
    private List<Student> studentList = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student addStudent) {
        Boolean result = true;

        for(Student student:studentList){
            if(student.getName().equals(addStudent.getName())){
                result=false;
                break;
            }
        }
        if(result){
            studentList.add(addStudent);
        }
        return result;
    }

    public double calculateClassAverage(){
        double result=0.0;
        double sum=0.0;
        if(studentList.size()==0){throw new ArithmeticException("No student in the class");}
        else{
            for(Student student:studentList){
                if(student.calculateAverage()==0){throw new ArithmeticException("No marks present");}
                sum+=student.calculateAverage();
            }
        }
        if (studentList.size() != 0) {
            result = sum / studentList.size();
        }
        return Math.round(result * 100.0) / 100.0;

    }

    public double calculateClassAverageBySubject(Subject subject){
        double result = 0.0;
        double sum = 0.0;
        int counter = 0;
        for (Student student:studentList) {
            if(student.calculateSubjectAverage(subject)!=0){
                sum += student.calculateSubjectAverage(subject);
                counter++;
            }
        }
        if (counter != 0) {
            result = sum / counter;
        }
        return result;

    }

    public Student findStudentByName(String name){
        if(name.isEmpty()){throw new IllegalArgumentException("Student name must not be empty!");}
        else{
            Student result=null;
            if(studentList.size()==0){throw new IllegalStateException("No students to search!");}
            for(Student student:studentList){

                if(student.getName().equals(name)){
                    result=student;
                    break;
                }
            }
            if(result==null){throw new IllegalArgumentException("Student by this name cannot be found!");}
            return result;
        }

    }

    public String listStudentNames() {

        String result = "";
        for (Student student : studentList) {
            result +=student.getName()+ ", ";
        }
        return result.substring(0,result.length()-2);
    }

    public List<StudyResultByName> listStudyResults(){
        List<StudyResultByName> studyresult=new ArrayList<>();
        for(Student student:studentList){
            studyresult.add(new StudyResultByName(student.getName(),student.calculateAverage()));
        }
        if(studyresult.size()==0){throw new IllegalStateException("No students to list results!");}
        return studyresult;
    }

    public boolean removeStudent(Student removeStudent) {
        Boolean result = false;
        for (Student student : studentList) {
            if (student.getName().contains(removeStudent.getName())) {
                studentList.remove(removeStudent);
                result = true;
            }

        }

        return result;
    }

    public Student repetition(){
        Student result=null;
        if(studentList.size()==0){throw new IllegalStateException("No students to select for repetition!");}
        else{
            int index=rnd.nextInt(studentList.size());
            result=studentList.get(index);
        }
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassRecords that = (ClassRecords) o;

        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (rnd != null ? !rnd.equals(that.rnd) : that.rnd != null) return false;
        return studentList != null ? studentList.equals(that.studentList) : that.studentList == null;
    }

    private boolean isEmpty(String stringToCheck){
        return (stringToCheck=="");
    }


}
