package com.ebay.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.ebay.BasePage.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class Login extends BaseClass{
	
	By HamburgerMenu = By.id("home");
	By LoginBtn = By.id("com.ebay.mobile:id/logo");
	By SignIn = By.xpath("//android.widget.ImageButton[@resource-id='com.ebay.mobile:id/home']");
	By Username = By.xpath("//*[text()='Email or username']");
	By Password = By.xpath("//*[text()='Password']");	
	By SignInBtn =By.xpath("//*[text()='SIGN IN']");
	AndroidDriver driver;
	public Login() {
		this.driver=driver;		
	}
	/**
	 * This method clicks the Hamburger menu
	 * @param driver
	 */
	public void clickHamburgerMenu(AndroidDriver driver) {
		
		driver.findElement(HamburgerMenu).click();
		appWait(driver).until(ExpectedConditions.elementToBeClickable(Username));
	}
	/**
	 * I have created this method with my understanding but i am not able to capture the screenshot as it is blocked by application 
	 * This method use to login to application
	 * @param driver
	 * @throws IOException
	 */
public void login(AndroidDriver driver) throws IOException {
	    driver.findElement(SignIn).click();
		driver.findElement(Username).sendKeys(propertiesFileReader().getProperty("Username"));
		driver.findElement(Password).sendKeys(propertiesFileReader().getProperty("Password"));
		driver.findElement(SignInBtn).click();
		
	}
	
	
}
