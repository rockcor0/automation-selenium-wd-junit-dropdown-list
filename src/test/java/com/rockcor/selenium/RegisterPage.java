/**
 * 
 */
package com.rockcor.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ricardodelgadocarreno
 *
 */
public class RegisterPage extends Base{
	
	/**
	 * Constants with locators
	 */
	//private final static String URL = "http://demo.guru99.com/test/newtours/";
	private final static By LOCATOR_REGISTER_LINK = By.linkText("REGISTER");
	//private final static By LOCATOR_REGISTER_XPATH = By.xpath("//a[@data-target='#modalUserLogin']");
	//private final static By LOCATOR_CLOSE_ADD = By.xpath("//div[@id='closeBtn']");
	private final static By LOCATOR_REGISTER_PAGE_FOUND = By.xpath("//img[@src='images/mast_register.gif']");
	private final static By LOCATOR_REGISTER_EMAIL = By.id("email");
	private final static By LOCATOR_REGISTER_PASS = By.name("password");
	private final static By LOCATOR_REGISTER_PASS_CONF = By.cssSelector("input[name='confirmPassword']");
	private final static By LOCATOR_REGISTER_SUBMIT_BTN = By.name("submit");
	private final static By LOCATOR_REGISTER_MESSAGE_SUCCESS = By.tagName("font");
	
	private final static String USERNAME = "qualityAdmin123!=";
	private final static String PASSWORD = "qualityAdmin123!=";
	
	public final static String REGISTER_SUCCESS_MESSAGE = "Note: Your user name is " + USERNAME + ".";

	/**
	 * Constructor class
	 * @param driver
	 */
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Register a user
	 * @throws InterruptedException
	 */
	public void registeredUser() throws InterruptedException {
		click(LOCATOR_REGISTER_LINK);
		implicitlyWait(2000);
		
		if(isDisplayed(LOCATOR_REGISTER_PAGE_FOUND)) {
			sendKeys(USERNAME, LOCATOR_REGISTER_EMAIL);
			sendKeys(PASSWORD, LOCATOR_REGISTER_PASS);
			sendKeys(PASSWORD, LOCATOR_REGISTER_PASS_CONF);
			click(LOCATOR_REGISTER_SUBMIT_BTN);

		}
		else {
			System.out.print("Register page was not found");
		}	
	}
	
	/**
	 * Message when user is registered
	 * @return
	 */
	public String registerMessage() {
		
		List<WebElement> fonts = findElements(LOCATOR_REGISTER_MESSAGE_SUCCESS);
		
		String resultS = "Note: Your user name is " + USERNAME + ".";
		
		for (WebElement webElement : fonts) {
			System.out.println(fonts.indexOf(webElement) + " - " + webElement.getText());
		}
		
		return getText(fonts.get(5));
	}

}
