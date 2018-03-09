import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CompanyTest {

    public static final String EMPLOYEECONTENT = "Frank Underwood\n" +
            "Claire Underwood\n" +
            "Han Solo";
    public static final String PROJECTCONTENT = "Java\n" +
            "SQL\n" +
            "HTML";
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();
    public String testDirectoryName;
    public Path pathEmployee;
    public Path pathProject;
    public Company company;

    @Before
    public void setUp() throws IOException {
        testDirectoryName = folder.getRoot().getAbsolutePath();
        pathEmployee = Paths.get(testDirectoryName, "EmployeeTest.txt");
        Files.write(pathEmployee, EMPLOYEECONTENT.getBytes());
        pathProject = Paths.get(testDirectoryName, "ProjectTest.txt");
        Files.write(pathProject, PROJECTCONTENT.getBytes());
    }

    @After
    public void tearDown() {
        testDirectoryName = null;
        pathEmployee = null;
        pathProject = null;
    }

    @Test
    public void testCreateCompany() {
        company = new Company(pathEmployee.toString(), pathProject.toString());
        assertThat(company instanceof Company, is(true));
    }

    @Test
    public void testMissingEmployeeFile() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Employee filename must not be empty!");
        company = new Company("", pathProject.toString());
    }

    @Test
    public void testMissingProjectFile() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Project filename must not be empty!");
        company = new Company(pathEmployee.toString(), "");
    }

    @Test
    public void testEmployeeFileNotfound() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("File not found");
        company = new Company("xyz.txt", pathProject.toString());
    }

    @Test
    public void testProjectFileNotfound() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("File not found");
        company = new Company(pathEmployee.toString(), "zyx.txt");
    }

    @Test
    public void testAddProjektItem() {
        company = new Company(pathEmployee.toString(), pathProject.toString());
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 8, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                company.getEmployees().get(2)
        );


        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 19, 8, 00),
                LocalDateTime.of(2017, 10, 19, 16, 00),
                company.getEmployees().get(2)

        );
        assertThat(company.getTimeSheet().get(0).getProject().getName(), is("Java"));
        assertThat(company.getTimeSheet().get(0).getParticipant().getFullName(), is("Han Solo"));
    }

    @Test
    public void testAddProjektItemMissingProject() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Project input cannot be null;");
        company = new Company(pathEmployee.toString(), pathProject.toString());
        company.addProjectItem(null,
                LocalDateTime.of(2017, 10, 18, 8, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                company.getEmployees().get(2)
        );

    }

    @Test
    public void testAddProjectItemMissingEmployee() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Employee input cannot be null;");
        company = new Company(pathEmployee.toString(), pathProject.toString());
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 8, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                null

        );
    }

    @Test
    public void testAddProjectItemProjectNotFound() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Project not found in Projectlist");
        company = new Company(pathEmployee.toString(), pathProject.toString());
        company.addProjectItem(new Project("Ruby"),
                LocalDateTime.of(2017, 10, 18, 8, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                company.getEmployees().get(2)
        );
    }

    @Test
    public void testAddProjektItemEmployeeNotFound() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Employee not found in Employeelist");
        company = new Company(pathEmployee.toString(), pathProject.toString());
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 8, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                new Employee("Luke", "Skywalker")
        );
    }

    @Test
    public void testAddProjectFromDateIsBiggerThanToDate() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Project start time cannot be bigger than the end time");

        company = new Company(pathEmployee.toString(), pathProject.toString());
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 15, 00),
                LocalDateTime.of(2017, 10, 18, 11, 00),
                company.getEmployees().get(2));
    }

    @Test
    public void testAddProjectDatesOnDifferentDay() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Start date and end date must be on the same day");

        company = new Company(pathEmployee.toString(), pathProject.toString());
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 8, 00),
                LocalDateTime.of(2017, 10, 19, 11, 00),
                company.getEmployees().get(2));
    }


    @Test
    public void testfindProjectItemsByEmployee() {
        company = new Company(pathEmployee.toString(), pathProject.toString());
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 8, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                company.getEmployees().get(2)
        );
        company.addProjectItem(new Project("SQL"),
                LocalDateTime.of(2017, 10, 19, 8, 00),
                LocalDateTime.of(2017, 10, 19, 16, 00),
                company.getEmployees().get(2)
        );
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 10, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                company.getEmployees().get(0)
        );
        company.addProjectItem(company.getProjects().get(1),
                LocalDateTime.of(2017, 10, 19, 12, 00),
                LocalDateTime.of(2017, 10, 19, 16, 00),
                company.getEmployees().get(0)
        );
        company.addProjectItem(company.getProjects().get(2),
                LocalDateTime.of(2017, 10, 20, 8, 00),
                LocalDateTime.of(2017, 10, 20, 18, 00),
                company.getEmployees().get(0)
        );

        assertThat(company.findProjectItemsByEmployee(new Employee("Frank", "Underwood")).size(), is(3));
        assertThat(company.findProjectItemsByEmployee(new Employee("Frank", "Underwood")).get(0).workHours().toHours(), is(6L));
        assertThat(company.findProjectItemsByEmployee(new Employee("Frank", "Underwood")).get(2).workHours().toHours(), is(10L));


        assertThat(company.findProjectItemsByEmployee(new Employee("Han", "Solo")).size(), is(2));
        assertThat(company.findProjectItemsByEmployee(new Employee("Han", "Solo")).get(1).getProject().getName(), is("SQL"));
    }

    @Test
    public void testGenerateReport() {
        company = new Company(pathEmployee.toString(), pathProject.toString());
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 8, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                company.getEmployees().get(2)
        );
        company.addProjectItem(new Project("SQL"),
                LocalDateTime.of(2017, 10, 19, 8, 00),
                LocalDateTime.of(2017, 10, 19, 16, 00),
                company.getEmployees().get(2)
        );
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 10, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                company.getEmployees().get(0)
        );
        company.addProjectItem(company.getProjects().get(1),
                LocalDateTime.of(2017, 10, 19, 12, 00),
                LocalDateTime.of(2017, 10, 19, 16, 00),
                company.getEmployees().get(0)
        );
        company.addProjectItem(company.getProjects().get(2),
                LocalDateTime.of(2017, 10, 20, 8, 00),
                LocalDateTime.of(2017, 10, 20, 18, 00),
                company.getEmployees().get(0)
        );


        assertThat(company.generateReport(new Employee("Frank", "Underwood"), 2017, 10, new Locale("hu", "HU")), is(
                "Munkaidõ nyilvántartás\n" +
                        "Frank Underwood 2017 október hónapjában 20 órát dolgozott. \n" +
                        "Projektenként részletezve:\n" +
                        "\t Projekt\t Óra\n" +
                        "\t\tJava\t\t6\n" +
                        "\t\tSQL\t\t4\n" +
                        "\t\tHTML\t\t10\n"
        ));

        assertThat(company.generateReport(new Employee("Han", "Solo"), 2017, 10, new Locale("en", "EN")), is(
                "Timesheet \n" +
                        "Han Solo worked 16 hours in October 2017. \n" +
                        "Itemize:\n" +
                        "\t Project\t Hour\n" +
                        "\t\tJava\t\t8\n" +
                        "\t\tSQL\t\t8\n"
        ));
    }

    @Test
    public void testWriteFile() {
        company = new Company(pathEmployee.toString(), pathProject.toString());
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 8, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                company.getEmployees().get(2)
        );
        company.addProjectItem(new Project("SQL"),
                LocalDateTime.of(2017, 10, 19, 8, 00),
                LocalDateTime.of(2017, 10, 19, 16, 00),
                company.getEmployees().get(2)
        );
        company.addProjectItem(company.getProjects().get(0),
                LocalDateTime.of(2017, 10, 18, 10, 00),
                LocalDateTime.of(2017, 10, 18, 16, 00),
                company.getEmployees().get(0)
        );
        company.addProjectItem(company.getProjects().get(1),
                LocalDateTime.of(2017, 10, 19, 12, 00),
                LocalDateTime.of(2017, 10, 19, 16, 00),
                company.getEmployees().get(0)
        );
        company.addProjectItem(company.getProjects().get(2),
                LocalDateTime.of(2017, 10, 20, 8, 00),
                LocalDateTime.of(2017, 10, 20, 18, 00),
                company.getEmployees().get(0)
        );

        company.writeToFile(new Employee("Frank", "Underwood"), 2017, 10, new Locale("hu", "HU"));

    }



}
