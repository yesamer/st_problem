/**
 * 
 */
package it.yesamer.st.model;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import it.yesamer.st.manager.SalesTaxesLabels;
import it.yesamer.st.utils.StringUtils;

/**
 * This class describes a Good entity, i.e. an Item of the {@link Cart}.
 * 
 * @author Yeser Amer
 *
 */
public class Good {

	private static Logger logger = Logger.getLogger(Good.class);

	/**
	 * The good's quantity
	 */
	private int quantity;
	/**
	 * Good's description
	 */
	private String description;
	/**
	 * Good's category. See {#link GoodCategory}
	 */
	private GoodCategory category;
	/**
	 * If TRUE the is good is imported. FALSE otherwise.
	 */
	private boolean imported;
	/**
	 * Good's price, without taxes.
	 */
	private BigDecimal price;

	public Good(String quantity, String description, GoodCategory category, boolean imported, String price) {
		if (StringUtils.validateString(quantity) && StringUtils.validateString(description) &&
				StringUtils.validateString(price) && category != null) {
			this.quantity = Integer.parseInt(quantity);
			this.description = description;
			this.category = category;
			this.imported = imported;
			this.price = new BigDecimal(price);
		} else {
			String message = "Wrong parameters passed to Good constructor "
					+ "(must be not null and not empty)";
			logger.error(message);
			throw new IllegalStateException();
		}
	}

	/* Getters and Setters */

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public GoodCategory getCategory() {
		return category;
	}

	public void setCategory(GoodCategory category) {
		this.category = category;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return A full Good description.
	 */
	public String getLongDescription() {
		StringBuffer longDescription = new StringBuffer();
		longDescription.append(quantity).append(" ")
			.append(imported ? SalesTaxesLabels.IMPORTED : "").append(" ")
			.append(description).append(": ");
		return longDescription.toString();
	}

}
