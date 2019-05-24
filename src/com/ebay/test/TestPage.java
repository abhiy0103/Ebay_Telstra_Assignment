package com.ebay.test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ebay.BasePage.BaseClass;
import com.ebay.pages.HomeScreen;
import com.ebay.pages.Login;
import com.ebay.pages.ProductDeatailPage;

import io.appium.java_client.android.AndroidDriver;

public class TestPage extends BaseClass{
	
	AndroidDriver driver;
	
	HomeScreen HomeScr = new HomeScreen();
	Login LoginScr = new Login();
	ProductDeatailPage PDdetailsScr = new ProductDeatailPage();
	@Test
	@Parameters({"device","appPackage","appActivity","url"})
	public void ebayAssignmentTest(String device, String appPackage, String appActivity, String url) throws InterruptedException, Exception {
		
		
		driver = new AndroidDriver(getAppiumServerURL(url), GenerateCapabilities(device, appPackage, appActivity));		
		//LoginScr.clickHamburgerMenu();		
		//LoginScr.login();
		HomeScr.verifyHomeScreen(driver);
		captureScreenshot(driver,"atHomescreen");
		HomeScr.enterSearchItem(driver);
		captureScreenshot(driver,"SearchValue");
		PDdetailsScr.SelectProduct(driver);
		captureScreenshot(driver,"SelectedValue");
		PDdetailsScr.getProductDetails(driver);
		captureScreenshot(driver,"ProductDetails");
		PDdetailsScr.clickReviewBtn(driver);
		captureScreenshot(driver,"ReviewScreen");
		PDdetailsScr.getCheckoutValues(driver);
		captureScreenshot(driver,"CheckOutScreen");
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			captureScreenshot(driver, result.getName());
			System.out.println(result);
		}
		driver.quit();
		
	}

}
