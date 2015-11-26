/**
 * 
 */
package it.yesamer.st.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * It represents a Shopping Cart, i.e. a container for a list of {@link Good}
 * 
 * @author Yeser Amer
 *
 */
public class Cart {

	/**
	 * The list of all {@link Goods} contained in the Cart
	 */
	private List<Good> goods;

	public Cart() {
		/* It initialites the goods list */ 
		goods = new ArrayList<Good>();
	}

	/**
	 * @return An <b>unmodifiable</b> List of {@link Good} objects.
	 */
	public List<Good> getGoods() {
		return Collections.unmodifiableList(goods);
	}

	/**
	 * @param good A {@link Good} which will be added to the Cart.
	 * @return A boolean set to true if the goods list has been modified.
	 */
	public boolean addGood(Good good) {
		return goods.add(good);
	}

	/**
	 * @param good A {@link Good} which will be removed to the Cart.
	 * @return A boolean set to true if the goods list has been modified.
	 */
	public boolean removeGood(Good good) {
		return goods.remove(good);
	}

}
