package introjunit;

import org.junit.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;


public class GentlemanTest {
    @Test
    public void sayHello() throws Exception {

        assertThat(new Gentleman().sayHello("John Doe"),equalTo("Hello John Doe"));

    }

    @Test
    public void sayHello2() throws Exception {

        assertThat(new Gentleman().sayHello(null),equalTo("Hello Anonymous"));

    }

}