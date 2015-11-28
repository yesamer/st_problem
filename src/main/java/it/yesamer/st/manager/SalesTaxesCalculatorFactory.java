package it.yesamer.st.manager;

/**
 * This class implements the FACTORY pattern for {@link SalesTaxesCalculator}.
 * At the time, it manages only one implementation
 * {@link SalesTaxesCalculatorImpl}. But in future can be useful use this
 * strategy to handle multiple implementations of {@link SalesTaxesCalculator}
 * 
 * @author Yeser Amer
 */
public class SalesTaxesCalculatorFactory {

	/**
	 * @return A {@link SalesTaxesCalculator} implementation
	 */
	public static SalesTaxesCalculator createCalculator() {
		return new SalesTaxesCalculatorImpl();
	}
}
