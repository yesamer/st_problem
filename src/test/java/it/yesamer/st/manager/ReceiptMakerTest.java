package it.yesamer.st.manager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.yesamer.st.model.Cart;
import it.yesamer.st.model.Good;
import it.yesamer.st.model.GoodCategory;

/**
 * It tests the {@link ReceiptMaker} entity class behavior.
 * 
 * @author Yeser Amer
 */
public class ReceiptMakerTest {

	private ReceiptMaker maker;
	private Cart cart;

	@Before
	public void setUp() {
		maker = new ReceiptMaker();
		cart = new Cart();
	}

	/**
	 * It tests the behavior of an empty {@link Cart} 
	 */
	@Test
	public void testEmptyCart() {
		String receipt = 
				"Sales Taxes: 0.00" + 
				System.lineSeparator() + 
				"Total: 0.00" + 
				System.lineSeparator();
		assertEquals(receipt, maker.calculateReceipt(cart));
	}

	/**
	 * It tests the behavior of INPUT 1
	 */
	@Test 
	public void testReceipt1() {
		String receipt = 
				"1 book: 12.49" + 
				System.lineSeparator() +
				"1 music CD: 16.49" +
				System.lineSeparator() +
				"1 chocolate bar: 0.85" + 
				System.lineSeparator() + 
				"Sales Taxes: 1.50" +
				System.lineSeparator() + 
				"Total: 29.83" + 
				System.lineSeparator();
		Good book = new Good("1", "book", GoodCategory.BOOK, false, "12.49");
		Good cd = new Good("1", "music CD", GoodCategory.GENERIC, false, "14.99");
		Good food = new Good("1", "chocolate bar", GoodCategory.FOOD, false, "0.85");
		cart.addGood(book);
		cart.addGood(cd);
		cart.addGood(food);
		assertEquals(receipt, maker.calculateReceipt(cart));
	}

	/**
	 * It tests the behavior of INPUT 2
	 */
	@Test 
	public void testReceipt2() {
		String receipt = 
				"1 imported box of chocolates: 10.50" + 
				System.lineSeparator() +
				"1 imported bottle of parfume: 54.65" +
				System.lineSeparator() + 
				"Sales Taxes: 7.65" +
				System.lineSeparator() + 
				"Total: 65.15" + 
				System.lineSeparator();
		Good box = new Good("1", "box of chocolates", GoodCategory.FOOD, true, "10.00");
		Good parfume = new Good("1", "bottle of parfume", GoodCategory.GENERIC, true, "47.50");
		cart.addGood(box);
		cart.addGood(parfume);
		assertEquals(receipt, maker.calculateReceipt(cart));
	}

	/**
	 * It tests the behavior of INPUT 1
	 */
	@Test
	public void testReceipt3() {
		String receipt = 
				"1 imported bottle of perfume: 32.19" + 
				System.lineSeparator() +
				"1 bottle of perfume: 20.89" +
				System.lineSeparator() + 
				"1 packet of headache pills: 9.75" +
				System.lineSeparator() +
				"1 imported box of chocolates: 11.85" +
				System.lineSeparator() + 
				"Sales Taxes: 6.70" +
				System.lineSeparator() + 
				"Total: 74.68" + 
				System.lineSeparator();
		Good parfume = new Good("1", "bottle of perfume", GoodCategory.GENERIC, true, "27.99");
		Good bottle = new Good("1", "bottle of perfume", GoodCategory.GENERIC, false, "18.99");
		Good pills = new Good("1", "packet of headache pills", GoodCategory.MEDICAL, false, "9.75");
		Good box = new Good("1", "box of chocolates", GoodCategory.FOOD, true, "11.25");
		cart.addGood(parfume);
		cart.addGood(bottle);
		cart.addGood(pills);
		cart.addGood(box);
		assertEquals(receipt, maker.calculateReceipt(cart));
	}

	/**
	 * It prints the receipt to console after every test.
	 */
	@After
	public void printToConsole() {
		System.out.println(maker.calculateReceipt(cart));
	}

}
