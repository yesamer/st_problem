package it.yesamer.st.utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * It tests every static method inside {@link StringUtil} class.
 * 
 * @author Yeser Amer
 */
public class StringUtilsTest {

	/**
	 * Testing StringUtils.validateString() method with all possible string state.
	 */
	@Test
	public void validateStringTest() {
		assertTrue(StringUtils.validateString("Test"));
		assertFalse(StringUtils.validateString(""));
		assertFalse(StringUtils.validateString(null));
	}

}
