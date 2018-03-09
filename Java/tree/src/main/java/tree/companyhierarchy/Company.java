package tree.companyhierarchy;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Company  {

    private Employee head;
    private Set<Employee> employees= new TreeSet<>();

    public Company(String headEmail, String headName) {
        this.head =new Employee(headEmail, headName);
        employees.add(new Employee(headEmail, headName));
    }

    public void addEmployee(String email,String name ,String bossEmail){
        employees.add(new Employee(email,name,bossEmail));
    }

    public Employee findByEmail(String searchIn){
        for(Employee employee:employees){
            if(employee.getEmail().equals(searchIn)){
                return employee;
            }
        }
        return null;
    }

    public Employee findBossOf(String searchIn){
        for(Employee employee:employees){
            if(employee.getEmail().equals(searchIn)){
                for(Employee employee2:employees){
                    if(employee.getBossEmail().equals(employee2.getEmail())){
                        return employee2;
                    }
                }
            }
        }
        return null;
    }

    public List<Employee> employeesOf(String searchIn){
        List<Employee> result= new ArrayList<>();
        for(Employee employee:employees){
            if(employee.getBossEmail()!=null) {
                if (employee.getBossEmail().equals(searchIn)) {
                    result.add(employee);
                }
            }
        }
        return result;
    }


}
