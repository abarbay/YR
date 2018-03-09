package exceptions.polinom;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class PolynomialTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void constructorDoubleNullParameterShouldThrowException() throws Exception {
        double[] coefficients = null;
        exception.expect(NullPointerException.class);
        exception.expectMessage("coefficients is null");
        new Polinom(coefficients);
    }

    @Test
    public void constructorStringNullParameterShouldThrowException() throws Exception {
        String[] coefficients = null;
        exception.expect(NullPointerException.class);
        exception.expectMessage("coefficientStrs is null");
        new Polinom(coefficients);
    }

    @Test
    public void constructorStringInvalidCoefficientShouldThrowException() throws Exception {
        String[] coefficientStrs = new String[]{"a", "1", "2"};
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Illegal coefficients, not a number");
        exception.expectCause(instanceOf(NumberFormatException.class));
        new Polinom(coefficientStrs);
    }

    @Test
    public void constructorStringShouldConvert() throws Exception {
        String[] coefficientStrs = new String[]{"1", "2", "2"};

        Polinom polynomial = new Polinom(coefficientStrs);

        double[] expected = new double[] {1,2,2};
        assertThat(polynomial.getCoefficients(), equalTo(expected));
    }

    @Test
    public void evaluate() throws Exception {
        Polinom p = new Polinom(new double[]{1, 2, 3});
        double x = 1;
        assertThat(p.evaluate(x), equalTo(x*x+2*x+3));
        x = 2;
        assertThat(p.evaluate(x), equalTo(x*x+2*x+3));
        x = -2;
        assertThat(p.evaluate(x), equalTo(x*x+2*x+3));
        Polinom p2 = new Polinom(new double[]{1, 1, 0, 1});
        x = 3;
        assertThat(p2.evaluate(x), equalTo(x*x*x + x*x + 1));
    }

}