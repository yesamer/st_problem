/**
 * 
 */
package it.yesamer.st.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * It contains useful static methods for Mathematical formulas
 * 
 * @author Yeser Amer
 */
public class MathUtils {

	// Constructor has been set to private, so it cannot be instantiated.
	private MathUtils() {
	}

	/**
	 * @param value A {@link BigDecimal} which represents the value to round.
	 * @param increment A {@link BigDecimal} representing the nearest increment.
	 * @return A {@link} BigDecimal rounded up to the nearest increment.
	 */
	public static BigDecimal roundUp(BigDecimal value, BigDecimal increment) {
		return round(value, increment, RoundingMode.UP);
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
	
	/**
	 * It calculates the value of a base and his specified percentage.
	 * (base * (percentage / 100))
	 * @param base 
	 * @param percentage
	 * @return A {@link BigDecimal} which contains the percentage value.
	 */
	public static BigDecimal percentage(BigDecimal base, BigDecimal percentage){
	    return roundUp(base.multiply(percentage).divide(new BigDecimal(100)), new BigDecimal("0.05"));
	}
}
