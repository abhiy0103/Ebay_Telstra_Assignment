
package com.ebay.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;



/**
 * @author DBN
 *
 */
public class BaseClass {
	
	/**
	 * This method set the capabilities of the execution device
	 * @param device
	 * @param appPackage
	 * @param appActivity
	 * @return
	 */
	public Capabilities GenerateCapabilities(String device, String appPackage, String appActivity) {
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(MobileCapabilityType.UDID, device);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		return capabilities;	
	}
	
	/**
	 * This method reads the value from the property file.
	 * @return
	 * @throws IOException
	 */
	
public Properties propertiesFileReader() throws IOException {
	 File file = new File("./TestData.properties");
			 //"E:\\JPN Softwares\\Selenium-Appium_18 Jan 2019\\Ebay_Telstra_Assignment\\TestData.properties");
	FileInputStream objfile = new FileInputStream(file);
	Properties prop = new Properties();
	prop.load(objfile);
	return prop;
	
}

/**
 * This is a explict wait function
 * @param driver
 * @return
 */
	public WebDriverWait appWait(AndroidDriver driver)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		return wait;
	}
	
	/**
	 * This gets the server rl
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 */
	
	public URL getAppiumServerURL(String url) throws MalformedURLException {
		URL urlocator = new URL(url);
		return urlocator;
	}
	
	/**
	 * This method used for swipping up
	 * @param driver
	 * @param startPercentage
	 * @param endPercentage
	 * @param anchorPercentage
	 */
	
	public void verticalSwipe(AndroidDriver driver,double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage); 
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }
	
	/**
	 * This method use to capture screenshot
	 * @param driver
	 * @param screenshotName
	 */
	public static void captureScreenshot(AndroidDriver driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot" + e.getMessage());
		} 
	}
	
	
}
