import java.io.*;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Company {



    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<ProjectItem> timeSheet = new ArrayList<>();

    public Company(String employeeList, String projectList) {
        loadEmployeeFile(employeeList);
        loadProjectFile(projectList);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<ProjectItem> getTimeSheet() {
        return timeSheet;
    }

    private ProjectItem createProjectItem(Project project, LocalDateTime from, LocalDateTime to, Employee employee) {
        projectValidator(project);
        employeeValidator(employee);
        localDateTimeValidator(from, to);
        return new ProjectItem(project, from, to, employee);

    }

    public void addProjectItem(Project project, LocalDateTime from, LocalDateTime to, Employee employee) {
        ProjectItem item = createProjectItem(project, from, to, employee);
        timeSheet.add(item);
    }

    public void loadProjectFile(String fileName) {
        if (isEmpty(fileName.toString())) {
            throw new IllegalArgumentException("Project filename must not be empty!");
        }
        File file = new File(fileName);
        if (!file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException("File not found");
        }

        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = read.readLine()) != null) {
                String currentLine = line;
                projects.add(new Project(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadEmployeeFile(String fileName) {
        if (isEmpty(fileName.toString())) {
            throw new IllegalArgumentException("Employee filename must not be empty!");
        }
        File file = new File(fileName);
        if (!file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException("File not found");
        }
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {

            String line = "";

            while ((line = read.readLine()) != null) {
                String currentLine = line;
                String[] content = currentLine.split(" ");
                employees.add(new Employee(content[0], content[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(Employee employee, int year, int month, Locale locale) {
        try {
            File file = new File("report_" + year + "_" + month + "_" + locale.getISO3Country() + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter writeFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writeFile.write(generateReport(employee, year, month, locale));
            writeFile.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public List<ProjectItem> findProjectItemsByEmployee(Employee employee) {
        List<ProjectItem> result = new ArrayList<>();
        for (ProjectItem item : timeSheet) {
            if (employee.getFirstName().equals(item.getParticipant().getFirstName()) &&
                    employee.getLastName().equals(item.getParticipant().getLastName())) {
                result.add(item);
            }
        }
        return result;

    }

    public String generateReport(Employee employee, int year, int month, Locale locale) {
        List<ProjectItem> projectItems;
        projectItems = findProjectItemsByEmployee(employee);
        long sumTime = 0;
        String projects = "";
        int pyear = 0;
        Month pmonth = null;
        for (ProjectItem item : projectItems) {
            if (item.getFrom().getMonth().getValue() == month && item.getFrom().getYear() == year) {
                pyear = item.getFrom().getYear();
                pmonth = item.getFrom().getMonth();
                sumTime += item.workHours().toHours();
                projects += "\t\t" + item.getProject().getName() + "\t\t" + item.workHours().toHours() + "\n";
            }
        }
        String stringYear = "" + pyear;
        String report = ResourceBundle.getBundle("report", locale).getString("reportString");
        String formattedReport = MessageFormat.format(report,
                employee.getFullName(),
                stringYear,
                pmonth.getDisplayName(TextStyle.FULL, locale), sumTime);
        StringBuilder sb = new StringBuilder();
        sb.append(formattedReport);
        sb.append(projects);
        return sb.toString();
    }

    private void projectValidator(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Project input cannot be null;");
        }
        if (!projects.contains(project)) {
            throw new IllegalArgumentException("Project not found in Projectlist");
        }
    }

    private void employeeValidator(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee input cannot be null;");
        }
        if (!employees.contains(employee)) {
            throw new IllegalArgumentException("Employee not found in Employeelist");
        }
    }

    private void localDateTimeValidator(LocalDateTime from, LocalDateTime to) {
        if (from.isAfter(to)) {
            throw new IllegalArgumentException("Project start time cannot be bigger than the end time");
        }
        if (!from.toLocalDate().equals(to.toLocalDate())) {
            throw new IllegalArgumentException("Start date and end date must be on the same day");
        }
    }

    private boolean isEmpty(String str) {
        return (str == null || str.isEmpty());
    }


}
