package taskbased;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VerifyTheForntSize {
	@Test
	public void flikarttests() throws MalformedURLException, InterruptedException{
				
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
		dc.setCapability(MobileCapabilityType.UDID,"220b6806");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
		dc.setCapability("appPackage", "com.flipkart.android");
		dc.setCapability("appActivity", ".activity.HomeFragmentHolderActivity");
		dc.setCapability("noReset", true);
				
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 WebElement intialelement = driver.findElementByXPath("//android.widget.TextView[@text='Search for products']");
		 Thread.sleep(3000);
		 Dimension firstfont = intialelement.getSize();
		 System.out.println(firstfont);
		 
		driver.startActivity("com.android.settings", ".Settings$DisplaySettingsActivity");
		driver.findElementByXPath("//android.widget.TextView[@text='Font size']").click();
		Thread.sleep(3000);
//		driver.swipe(282, 860, 596, 860, 300);
		driver.tap(1, 596, 860, 300);
		Thread.sleep(2000);
			
		driver.startActivity("com.flipkart.android", ".activity.HomeFragmentHolderActivity");
		WebElement finalelement = driver.findElementByXPath("//android.widget.TextView[@text='Search for products']");
		Dimension secondfont = finalelement.getSize();
		System.out.println(secondfont);
		Thread.sleep(3000);
		Assert.assertNotEquals(firstfont, secondfont);
		
		driver.startActivity("com.android.settings", ".Settings$DisplaySettingsActivity");
		driver.findElementByXPath("//android.widget.TextView[@text='Font size']").click();
		Thread.sleep(3000);
		driver.tap(1, 282, 860, 300);
		
		driver.quit();
	}
}
