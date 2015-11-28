package it.yesamer.st.manager;

import java.math.BigDecimal;

import it.yesamer.st.model.Good;
import it.yesamer.st.model.GoodCategory;
import it.yesamer.st.utils.MathUtils;

/**
 * The default implementation of {@link SalesTaxesCalculator}
 * 
 * @author Yeser Amer
 */
public class SalesTaxesCalculatorImpl implements SalesTaxesCalculator {

	/* (non-Javadoc)
	 * @see it.yesamer.st.manager.SalesTaxesCalculator#calculateItemTaxes(it.yesamer.st.model.Good)
	 */
	@Override
	public BigDecimal calculateGoodTaxes(Good good) {
		/* percentage is the tax rate to apply at the price */
		BigDecimal percentage = new BigDecimal("0");
		/* If the Good is imported, it adds to percentage the imported tax rate */
		if (good.isImported())
			percentage = percentage.add(new BigDecimal(SalesTaxesConfiguration.IMPORTED_TAX_RATE));
		/* If the Good a Generic one, it adds to percentage the generic tax rate */
		if (good.getCategory() == GoodCategory.GENERIC)
			percentage = percentage.add(new BigDecimal(SalesTaxesConfiguration.GENERIC_TAX_RATE));
		/* If the calculated percentage is != 0, it calculates the sale tax. It return zero otherwise */
		if (percentage.compareTo(new BigDecimal("0")) != 0)
			return MathUtils.percentage(good.getPrice(), percentage);
		else
			return new BigDecimal("0");		
	}

}
