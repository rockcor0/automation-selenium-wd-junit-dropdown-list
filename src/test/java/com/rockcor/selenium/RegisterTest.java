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
public class RegisterTest {
	
	public final static String URL = "http://demo.guru99.com/test/newtours/";
	
	private WebDriver driver;
	private RegisterPage registerPage;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		registerPage = new RegisterPage(driver);
		driver = registerPage.chromeDriverConnection();
		registerPage.get(URL);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void registerTest() throws InterruptedException {
		registerPage.registeredUser();
		registerPage.implicitlyWait(1000);
		assertEquals(RegisterPage.REGISTER_SUCCESS_MESSAGE, registerPage.registerMessage());
	}

}
