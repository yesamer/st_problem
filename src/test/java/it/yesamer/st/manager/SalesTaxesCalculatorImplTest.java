package it.yesamer.st.manager;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import it.yesamer.st.model.Good;
import it.yesamer.st.model.GoodCategory;

/**
 * It tests the {@link SalesTaxesCalculatorImpl} entity class behavior.
 * 
 * @author Yeser Amer
 */
public class SalesTaxesCalculatorImplTest {

	/**
	 * Testing calculateGoodTaxes() method.
	 */
	@Test
	public void testCalculateGoodTaxes() {
		SalesTaxesCalculator calculator = new SalesTaxesCalculatorImpl();
		assertEquals(new BigDecimal("0"), calculator.calculateGoodTaxes(new Good("1", "book", GoodCategory.BOOK, false, "12.49")));
		assertEquals(new BigDecimal("1.50"), calculator.calculateGoodTaxes(new Good("1", "music CD", GoodCategory.GENERIC, false, "14.99")));
		assertEquals(new BigDecimal("7.15"), calculator.calculateGoodTaxes(new Good("1", "bottle of parfume", GoodCategory.GENERIC, true, "47.50")));
	}

}
