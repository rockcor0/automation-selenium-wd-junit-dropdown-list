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
public class LoginTest {
	
	public final static String URL = "http://demo.guru99.com/test/newtours/";
	
	private LoginPage loginPage;
	private WebDriver driver; 

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		driver = loginPage.chromeDriverConnection();
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
	public void loginTest() {
		loginPage.loginUser();
		loginPage.implicitlyWait(1000);
		assertEquals(LoginPage.SING_IN_SUCCESS_MESSAGE, loginPage.signInMessage());
	}

}
