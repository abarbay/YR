import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProjectTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testProjectName() {
        // Given
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Project name cannot be empty");
        // When
        expectedException.expect(IllegalArgumentException.class);
        Project p = new Project("");
    }
}
