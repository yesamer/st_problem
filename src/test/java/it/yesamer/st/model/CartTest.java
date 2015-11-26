package it.yesamer.st.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartTest {

	private Cart cart;
	private Good book;
	private Good food;

	@Before
	public void setUp() {
		cart = new Cart();
		book = new Good("1", "book", GoodCategory.BOOK, false, "12.49");
		food = new Good("2", "chocholate bar", GoodCategory.FOOD, false, "5.49");
	}

	@Test
	public void manageGoodsinCartTest() {
		assertTrue(cart.getGoods().isEmpty());
		assertTrue(cart.addGood(book));
		assertTrue(cart.addGood(food));
		assertEquals(2, cart.getGoods().size());
		assertTrue(cart.removeGood(book));
		assertEquals(1, cart.getGoods().size());
	}

}
