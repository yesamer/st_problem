/**
 * 
 */
package it.yesamer.st.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * It contains useful static method for rounding doubles
 * 
 * @author Yeser Amer
 */
public class RoundingUtils {

	// Constructor has been set to private, so it cannot be instantiated.
	private RoundingUtils() {
	}

	/**
	 * @param value A {@link BigDecimal} which represents the value to round.
	 * @param increment A {@link BigDecimal} representing the nearest increment.
	 * @return A {@link} BigDecimal rounded up to the nearest increment.
	 */
	public static BigDecimal roundUp(BigDecimal value, BigDecimal increment) {
		if (increment.signum() == 0)
	        return value;
	    else {
	        BigDecimal divided = value.divide(increment, 0, RoundingMode.UP);
	        BigDecimal result = divided.multiply(increment);
	        return result;
	    }
	}
	
	/**
	 * @param value A {@link BigDecimal} which represents the value to round.
	 * @param increment A {@link BigDecimal} representing the nearest increment.
	 * @param roundingMode The specified {@link RoundingMode}.
	 * @return A {@link BigDecimal} rounded to the nearest increment.
	 */
	public static BigDecimal round(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
		if (increment.signum() == 0)
	        return value;
	    else {
	        BigDecimal divided = value.divide(increment, 0, roundingMode);
	        BigDecimal result = divided.multiply(increment);
	        return result;
	    }
	}
}
