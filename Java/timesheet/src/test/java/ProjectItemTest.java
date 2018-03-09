import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProjectItemTest {

    Project project = new Project("Java");
    Employee jc = new Employee("John", "Connor");
    Employee bc = new Employee("Bill", "Smith");

    ProjectItem p1 = new ProjectItem(
            project,
            LocalDateTime.of(2017, 10, 9, 7, 15),
            LocalDateTime.of(2017, 10, 9, 16, 15),
            jc
    );

    ProjectItem p2 = new ProjectItem(
            project,
            LocalDateTime.of(2017, 10, 10, 8, 00),
            LocalDateTime.of(2017, 10, 10, 16, 00),
            bc
    );


    @Test
    public void testWorkHours() {
        assertThat(p1.workHours().toHours(), is(9L));
        assertThat(p2.workHours().toHours(), is(8L));

    }

    @Test
    public void testCreateProjectItem() {
        assertThat(p1.getParticipant().getFullName(), is("John Connor"));
        assertThat(p1.getProject().getName(), is("Java"));
        assertThat(p1.getFrom().toLocalTime().getHour(), is(7));


        assertThat(p2.getParticipant().getFirstName(), is("Bill"));
        assertThat(p2.getParticipant().getLastName(), is("Smith"));
        assertThat(p2.getProject().getName(), is("Java"));
        assertThat(p2.getTo().toLocalTime().getMinute(), is(00));
    }
}
