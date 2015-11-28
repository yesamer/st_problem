package it.yesamer.st.utils;

/**
 * It contains useful static methods for Mathematical formulas
 * 
 * @author Yeser Amer
 */
public class StringUtils {

	private static final String EMPTY_STRING = "";

	/**
	 * It checks if a passed string is empty or null.
	 * @param string
	 * @return true if string is not empty or not null, false otherwise.
	 */
	public static boolean validateString(String string) {
		return (string != null && (!string.trim().equals(EMPTY_STRING)));
	}

}
