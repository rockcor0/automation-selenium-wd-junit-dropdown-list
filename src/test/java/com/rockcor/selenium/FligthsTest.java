/**
 * 
 */
package com.rockcor.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * @author ricardodelgadocarreno
 *
 */
public class FligthsTest {
	
	public final static String URL = "http://demo.guru99.com/test/newtours/";

	private FligthsPage fligthsPage;
	private WebDriver driver;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fligthsPage = new FligthsPage(driver);
		driver = fligthsPage.chromeDriverConnection();
		driver.get(URL);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void bookFligth() {
		fligthsPage.bookFlight();
		assertEquals(fligthsPage.getSelectedPassengers(), FligthsPage.PASSENGERS_COUNT);
		assertEquals(fligthsPage.getSelectedDeparting(), FligthsPage.DEPARTING);
	}

}
