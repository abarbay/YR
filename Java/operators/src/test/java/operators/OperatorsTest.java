package operators;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class OperatorsTest {
     @Test
    public void isEven()  {
        assertThat(new Operators().isEven(5) , equalTo(false));

    }

    @Test
    public void isEven2()  {
        assertThat((new Operators().isEven(6)) , equalTo(true));

    }


}