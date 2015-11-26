package it.yesamer.st.utils;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import it.yesamer.st.utils.RoundingUtils;

/**
 * It tests every static method inside {@link RoundingUtil} class.
 * 
 * @author Yeser Amer
 */
public class RoundingUtilsTest {

	private static final BigDecimal INCREMENT = new BigDecimal("0.05");

	/**
	 * Testing RoundingUtils.round() method with increment of 0.05.
	 */
	@Test
	public void roundUpToNearestFiveCentsTest() {
		assertEquals(new BigDecimal("7.15"), RoundingUtils.roundUp(new BigDecimal("7.11"), INCREMENT));
		assertEquals(new BigDecimal("7.15"), RoundingUtils.roundUp(new BigDecimal("7.15"), INCREMENT));
		assertEquals(new BigDecimal("7.20"), RoundingUtils.roundUp(new BigDecimal("7.16"), INCREMENT));
		assertEquals(new BigDecimal("7.30"), RoundingUtils.roundUp(new BigDecimal("7.25678"), INCREMENT));
	}

	/**
	 * A generic test for RoundingUtils.round() method.
	 */
	@Test
	public void roundTest() {
		assertEquals(new BigDecimal("7.10"), RoundingUtils.round(new BigDecimal("7.11"), INCREMENT, RoundingMode.DOWN));
		assertEquals(new BigDecimal("7.15"), RoundingUtils.round(new BigDecimal("7.175"), INCREMENT, RoundingMode.HALF_DOWN));
		assertEquals(new BigDecimal("7.20"), RoundingUtils.round(new BigDecimal("7.175"), INCREMENT, RoundingMode.HALF_UP));
	}

}
