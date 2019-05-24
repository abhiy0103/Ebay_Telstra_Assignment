package com.ebay.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.ebay.BasePage.BaseClass;

import io.appium.java_client.android.AndroidDriver;

public class ProductDeatailPage extends BaseClass{
	AndroidDriver driver;
	public ProductDeatailPage() {
		
			this.driver = driver;
	}
	
	public static String IntemNameTobeValidated;
	public static String IntemPriceTobeValidated;
	
	By SelectBrand = By.xpath("//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_item_title'][@index='0']");
	By SelectProduct = By.xpath("//android.widget.RelativeLayout[@index='2']");
	By ItemName = By.id("textview_item_name");
	By ItemPrice = By.id("textview_item_price");
	By BuyItNowBtn = By.id("button_bin");
	By ReviewBtn = By.id("take_action");
	By CheckoutItemName = By.id("item_title");
	By CheckoutItemPrice = By.id("textview_item_price");
	
	
	/**
	 * This method selects product frm the list view
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void SelectProduct(AndroidDriver driver) throws InterruptedException {
		
		WebElement Parent= driver.findElement(SelectBrand);
		Parent.click();
		appWait(driver).until(ExpectedConditions.elementToBeClickable(SelectProduct));
		verticalSwipe(driver,0.5, 0.4, 0.6);
		driver.findElement(SelectProduct).click();
	}
	/**
	 * This method get the product details and store in a global variable
	 * @param driver
	 */
	
	public void getProductDetails(AndroidDriver driver) {
		appWait(driver).until(ExpectedConditions.elementToBeClickable(BuyItNowBtn));
		 IntemNameTobeValidated=driver.findElement(ItemName).getText().trim();
		 IntemPriceTobeValidated=driver.findElement(ItemPrice).getText().trim();		 
		 driver.findElement(BuyItNowBtn).click();
		 
	}
	
	/**
	 * This method clicks the review button
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void clickReviewBtn(AndroidDriver driver) throws InterruptedException {
		appWait(driver).until(ExpectedConditions.elementToBeClickable(ReviewBtn));	
		Assert.assertTrue(driver.findElement(ReviewBtn).isDisplayed());
		 driver.findElement(ReviewBtn).click();
	}
	
	/**
	 * This method compares the product details in the checkout screen with the previously taken values
	 * @param driver
	 */
	public void getCheckoutValues(AndroidDriver driver) {
		appWait(driver).until(ExpectedConditions.elementToBeClickable(ReviewBtn));		
		Assert.assertEquals(driver.findElement(CheckoutItemName).getText().trim(), IntemNameTobeValidated, "Item name is not displayed corectly");
		Assert.assertEquals(driver.findElement(CheckoutItemPrice).getText().trim(),IntemPriceTobeValidated,"Item price is not displayed corectly");
	}
	
	
}
