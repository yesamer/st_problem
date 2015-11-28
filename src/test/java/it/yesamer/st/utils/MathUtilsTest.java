package it.yesamer.st.utils;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import it.yesamer.st.utils.MathUtils;

/**
 * It tests every static method inside {@link MathUtil} class.
 * 
 * @author Yeser Amer
 */
public class MathUtilsTest {

	private static final BigDecimal INCREMENT = new BigDecimal("0.05");

	/**
	 * Testing MathUtils.round() method with increment of 0.05.
	 */
	@Test
	public void roundUpToNearestFiveCentsTest() {
		assertEquals(new BigDecimal("7.15"), MathUtils.roundUp(new BigDecimal("7.11"), INCREMENT));
		assertEquals(new BigDecimal("7.15"), MathUtils.roundUp(new BigDecimal("7.15"), INCREMENT));
		assertEquals(new BigDecimal("7.20"), MathUtils.roundUp(new BigDecimal("7.16"), INCREMENT));
		assertEquals(new BigDecimal("7.30"), MathUtils.roundUp(new BigDecimal("7.25678"), INCREMENT));
	}

	/**
	 * Testing MathUtils.round() method.
	 */
	@Test
	public void roundTest() {
		assertEquals(new BigDecimal("7.10"), MathUtils.round(new BigDecimal("7.11"), INCREMENT, RoundingMode.DOWN));
		assertEquals(new BigDecimal("7.15"), MathUtils.round(new BigDecimal("7.175"), INCREMENT, RoundingMode.HALF_DOWN));
		assertEquals(new BigDecimal("7.20"), MathUtils.round(new BigDecimal("7.175"), INCREMENT, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal("-7.20"), MathUtils.round(new BigDecimal("-7.175"), INCREMENT, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal("0.00"), MathUtils.round(new BigDecimal("0.00"), INCREMENT, RoundingMode.HALF_UP));
		assertEquals(new BigDecimal("7.175"), MathUtils.round(new BigDecimal("7.175"), new BigDecimal("0.0"), RoundingMode.HALF_UP));
	}
	
	/**
	 * Test for MathUtils.percentage() method.
	 */
	@Test
	public void percentageTest() {
		assertEquals(new BigDecimal("10.00"), MathUtils.percentage(new BigDecimal("100"), new BigDecimal("10")));
		assertEquals(new BigDecimal("7.13"), MathUtils.percentage(new BigDecimal("47.50"), new BigDecimal("15")));
		assertEquals(new BigDecimal("0.56"), MathUtils.percentage(new BigDecimal("11.25"), new BigDecimal("5")));
		assertEquals(new BigDecimal("-94.90"), MathUtils.percentage(new BigDecimal("-123.25"), new BigDecimal("77")));
		assertEquals(new BigDecimal("-4.80"), MathUtils.percentage(new BigDecimal("19.19"), new BigDecimal("-25")));
		assertEquals(new BigDecimal("639.26"), MathUtils.percentage(new BigDecimal("765.21"), new BigDecimal("83.54")));
	}

}
