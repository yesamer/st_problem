/**
 * 
 */
package it.yesamer.st.model;

import java.math.BigDecimal;

/**
 * This class describes a Good entity, i.e. an Item of the {@link Cart}.
 * 
 * @author Yeser Amer
 *
 */
public class Good {

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
		this.quantity = Integer.parseInt(quantity);
		this.description = description;
		this.category = category;
		this.setImported(imported);
		this.price = new BigDecimal(price);
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

	public Boolean getImported() {
		return imported;
	}

	public void setImported(Boolean imported) {
		this.imported = imported;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
