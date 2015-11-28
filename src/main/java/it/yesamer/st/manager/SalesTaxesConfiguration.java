package it.yesamer.st.manager;

/**
 * Iterface which contains all the label in the project. A better solution
 * could be to use a property file where to put all the string labels.
 * 
 * @author Yeser Amer
 */
public interface SalesTaxesConfiguration {

	/**
	 * The default Rounding Increment.
	 */
	public static String ROUNDING_INCREMENT = "0.05";

	/**
	 * The tax rate for a imported Good (see {@link Good})
	 */
	public static String IMPORTED_TAX_RATE = "5";

	/**
	 * The tax rate for a Good Generic Category (see {@link Good} and {@link GoodCategory})
	 */
	public static String GENERIC_TAX_RATE = "10";

}
