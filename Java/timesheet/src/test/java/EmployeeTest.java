import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EmployeeTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testEmployeeFirstName() {
        // Given
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("First name cannot be empty or null");
        // When
        Employee e = new Employee("", "Connor");
    }

    @Test
    public void testEmployeeLastName() {
        // Given
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Last name cannot be empty or null");
        // When
        Employee e = new Employee("Sarah", "");
    }


}
