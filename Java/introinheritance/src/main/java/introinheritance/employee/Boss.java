package introinheritance.employee;



public class Boss extends Employee {


    private int numberOfEmployees;

    public Boss(String name, String address, int salary, int numberOfEmployees) {
        super(name,address,salary);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double getSalary() {
       return super.getSalary()+(super.getSalary()*numberOfEmployees*super.getLEADERSHIP_FACTOR());

    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

}
