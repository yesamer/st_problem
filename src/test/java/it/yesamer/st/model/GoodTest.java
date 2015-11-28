package it.yesamer.st.model;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.junit.Before;
import org.junit.Test;

/**
 * It test the {@link Good} entity class behavior.
 * 
 * @author Yeser Amer
 */
public class GoodTest {
	
	/**
	 * It configures Logger (to off).
	 */
	@Before
	public void setupLogger() {
	    Logger rootLogger = Logger.getRootLogger();
	    rootLogger.setLevel(Level.OFF);
	}

	/**
	 * Testing {@link Cart} constructor.
	 */
	@Test(expected=IllegalStateException.class)
	public void constructorTest() {
		new Good(null, null, null, true, null);
	}

}
