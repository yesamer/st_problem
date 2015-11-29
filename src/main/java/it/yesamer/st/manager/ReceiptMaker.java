package it.yesamer.st.manager;

import java.math.BigDecimal;

import it.yesamer.st.model.Cart;
import it.yesamer.st.model.Good;
import it.yesamer.st.utils.MathUtils;

/**
 * This class is the project entry-point. Its aim is to generate a Receipt.
 * 
 * @author Yeser Amer
 */
public class ReceiptMaker {

	/**
	 * The {@link SalesTaxesCalculator} used to calculate the sales taxes for every {@link Good}
	 */
	private SalesTaxesCalculator taxesSalesCalculator;

	public ReceiptMaker() {
		/* It Initializes the taxesSalesCalulcator via Factory */
		taxesSalesCalculator = SalesTaxesCalculatorFactory.createCalculator();
	}

	/**
	 * @param A {@link Cart} 
	 * @return A {@link String} containing the receipt test.
	 */
	public String calculateReceipt(Cart cart) {
		BigDecimal totalTaxes = new BigDecimal("0.00");
		BigDecimal total = new BigDecimal("0.00");
		StringBuffer receipt = new StringBuffer();

		/* For every Good in the Cart, it calculates his own Sale Tax. Then, it adds 
		 * the results in totalTaxes and Total local variables.*/
		for (Good good : cart.getGoods()) {
			BigDecimal goodTaxes = taxesSalesCalculator.calculateGoodTaxes(good)
					.multiply(new BigDecimal(good.getQuantity()));
			BigDecimal goodPriceWithTaxes = good.getPrice().add(goodTaxes)
					.multiply(new BigDecimal(good.getQuantity()));
			totalTaxes = totalTaxes.add(goodTaxes);
			total = total.add(goodPriceWithTaxes);
			receipt.append(good.getLongDescription()).append(goodPriceWithTaxes)
					.append(System.lineSeparator());
		}

		/* Here, it appends the result to create a Receipt in String format */
		receipt.append(SalesTaxesLabels.SALES_TAXES).append(": ")
				.append(MathUtils.roundUp(
							totalTaxes, new BigDecimal(SalesTaxesConfiguration.ROUNDING_INCREMENT)))
				.append(System.lineSeparator());
		receipt.append(SalesTaxesLabels.TOTAL).append(": ")
				.append(total).append(System.lineSeparator());

		return receipt.toString();
	}

}
