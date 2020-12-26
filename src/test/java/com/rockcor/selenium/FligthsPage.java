/**
 * 
 */
package com.rockcor.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author ricardodelgadocarreno
 *
 */
public class FligthsPage extends Base{
	
	private final static By FLIGTHS_OPEN_PAGE = 	By.linkText("Flights");
	private final static By FLIGTHS_PAGE_LOCATOR = By.xpath("//img[@src='images/mast_flightfinder.gif']");
	private final static By FLIGTHS_DROPDOWN_LIST_PASSENGERS = By.name("passCount");
	private final static By FLIGTHS_DROPDOWN_LIST_DEPARTING = By.name("fromPort");
	public final static String PASSENGERS_COUNT = "4 ";
	public final static String DEPARTING = "Paris";
	
	
	public FligthsPage(WebDriver driver) {
		super(driver);
	}
	
	public void bookFlight() {
		click(FLIGTHS_OPEN_PAGE);
		
		implicitlyWait(2000);
		
		if (isDisplayed(FLIGTHS_PAGE_LOCATOR)) {
			System.out.println("Flights page was found!");
		} else {
			System.out.println("Fligths page was not fount");
		}
		
	}
	
	public String getSelectedPassengers() {
		
		WebElement dropdownList = findElement(FLIGTHS_DROPDOWN_LIST_PASSENGERS);
		List<WebElement> options = dropdownList.findElements(By.tagName("option"));
		
		System.out.println("Print elements: ");
		
		for (WebElement webElement : options) {
			System.out.println(getText(webElement));
			if (getText(webElement).equals(PASSENGERS_COUNT)) {
				click(webElement);
			}
		}
		
		String selected = "";
		
		for (WebElement webElement : options) {
			if (webElement.isSelected()) {
				selected = getText(webElement);
			}
		}
		
		return selected;
		
	}
	
	public String getSelectedDeparting() {
		Select selectList = new Select(findElement(FLIGTHS_DROPDOWN_LIST_DEPARTING));
		selectList.selectByVisibleText("Paris");
		return getText(selectList.getFirstSelectedOption());
	}

}
