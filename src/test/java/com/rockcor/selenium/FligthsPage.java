/**
 * 
 */
package com.rockcor.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author ricardodelgadocarreno
 *
 */
public class FligthsPage extends Base{
	
	private final static By FLIGTHS_OPEN_PAGE = 	By.linkText("Flights");
	private final static By FLIGTHS_PAGE_LOCATOR = By.xpath("//img[@src='images/mast_flightfinder.gif']");

	public FligthsPage(WebDriver driver) {
		super(driver);
	}
	
	public void bookFlight() {
		click(FLIGTHS_OPEN_PAGE);
		
		implicitlyWait(2000);
		
		if (isDisplayed(FLIGTHS_PAGE_LOCATOR)) {
			
		} else {
			System.out.println("Fligths page was not fount");
		}
		
	}

}
