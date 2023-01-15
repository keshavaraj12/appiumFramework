package drivermethods;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class BrowserStackSampleForIOS {
	@Test
	public void browserstackios() throws Throwable
	{
	DesiredCapabilities ds = new DesiredCapabilities();
	
	ds.setCapability("browserstack.user", "keshavaraj_LxpJA3");
	ds.setCapability("browserstack.key", "GPfd3yNZDPi7DujQkLbE");
	
	ds.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

    ds.setCapability("device", "iPhone 14 Pro Max");
    ds.setCapability("os_version", "16");
    
	ds.setCapability("project", "First Java Project");
	ds.setCapability("build", "browserstack-build-1");
	ds.setCapability("name", "first_test");
   
	 IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
     		new URL("http://hub-cloud.browserstack.com/wd/hub"), ds); 
	 IOSElement textButton = (IOSElement) new WebDriverWait(driver, 30).until(
	            ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
	        textButton.click();
	        IOSElement textInput = (IOSElement) new WebDriverWait(driver, 30).until(
	            ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
	        textInput.sendKeys("hello@browserstack.com");
	        Thread.sleep(1000);
	 
    driver.quit();
	
}
}
