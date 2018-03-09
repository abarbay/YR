package tree.companyhierarchy;

public class Employee implements Comparable<Employee> {
    private String email;
    private String name;
    private String bossEmail;


    public Employee(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Employee(String email, String name, String bossEmail) {
        this.email = email;
        this.name = name;
        this.bossEmail = bossEmail;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBossEmail() {
        return bossEmail;
    }

    @Override
    public int compareTo(Employee o) {
        return email.compareTo(o.email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return email != null ? email.equals(employee.email) : employee.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}
