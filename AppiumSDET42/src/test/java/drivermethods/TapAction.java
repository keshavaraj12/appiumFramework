package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TapAction {
	@Test
public void tapaction() throws MalformedURLException {
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
	dc.setCapability(MobileCapabilityType.UDID,"220b6806");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
	dc.setCapability("appPackage", "com.android.bbkcalculator");
	dc.setCapability("appActivity", ".Calculator");
	
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, dc);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	MobileElement value1 = (MobileElement) driver.findElementById("com.android.bbkcalculator:id/digit5");
	value1.tap(1, 500);
	MobileElement plus = (MobileElement) driver.findElementById("com.android.bbkcalculator:id/plus");
	plus.tap(1, 500);
	//driver.tap(1, 281, 1141, 500);
	MobileElement value2 = (MobileElement) driver.findElementById("com.android.bbkcalculator:id/digit2");
	value2.tap(1, 500);
	MobileElement equals = (MobileElement) driver.findElementById("com.android.bbkcalculator:id/equal");
	equals.tap(1, 500);
	MobileElement result = (MobileElement) driver.findElementById("com.android.bbkcalculator:id/input_edit");
	String r = result.getText();
	System.out.println("r= "+r);
}
}
