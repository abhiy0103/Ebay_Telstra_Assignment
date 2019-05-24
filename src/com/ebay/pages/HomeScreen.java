package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.ebay.BasePage.BaseClass;

import io.appium.java_client.android.AndroidDriver;

public class HomeScreen extends BaseClass{
	AndroidDriver driver;
	public HomeScreen() {
		
			this.driver = driver;
	}
	
	By HomepageItems = By.id("recyclerview_items");
	By SearchBox = By.id("search_box");
	By EnterSearchText = By.id("search_src_text");
	By SearchSelectionParent =By.id("com.ebay.mobile:id/suggestionList");
	By SearchSelectionChild =By.xpath("//android.widget.RelativeLayout[@index='0']");
	
	
	/**
	 * This method verify the Homescreen
	 * @param driver
	 */
	public void verifyHomeScreen(AndroidDriver driver) {
		appWait(driver).until(ExpectedConditions.elementToBeClickable(SearchBox));
		Assert.assertTrue(driver.findElement(HomepageItems).isDisplayed());
		System.out.println("Homescreen is displayed sussessfully");
	}
	
	/**
	 * This method enter the search value and selects the value from the search results
	 * @param driver
	 */
	 public void enterSearchItem(AndroidDriver driver) throws IOException {
		 Assert.assertTrue(driver.findElement(SearchBox).isDisplayed());
		 System.out.println("SearchBox is displayed");
		 driver.findElement(SearchBox).click();		 
		 driver.findElement(EnterSearchText).sendKeys(propertiesFileReader().getProperty("SearchData"));
		 driver.hideKeyboard();
		 WebElement SearchParent= driver.findElement(SearchSelectionParent);
		 WebElement SearchChild= SearchParent.findElement(SearchSelectionChild);
		 SearchChild.click();
		 
		 
	 }
}
