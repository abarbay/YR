package templatemethod.bank;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class YieldProductTest {

	@Test
	public void testRound() {
		//Given
		YieldProduct yieldProduct = new YieldProduct(123);
		//Then
		assertThat(yieldProduct.round(125.5), is(125));
	}



}

