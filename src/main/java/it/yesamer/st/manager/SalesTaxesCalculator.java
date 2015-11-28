package it.yesamer.st.manager;

import java.math.BigDecimal;

import it.yesamer.st.model.Good;

/**
 * The SalesTaxesCalculator aim is to calculate the tax rate of a single good.
 * It could exists many algorithms to instantiate a Sales Calculator, so this
 * interface describes the operation which every calculator must have.
 * 
 * @author Yeser Amer
 */
public interface SalesTaxesCalculator {

	/**
	 * It calculates the sale tax of a single {@link Good}.
	 * @param good A {@link Good} object 
	 * @return A {@link BigDecimal} containing the sale tax of the {@link Good}. 
	 */
	BigDecimal calculateGoodTaxes(Good good);

}
