package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Scroll {
@Test
	public void scroll() throws MalformedURLException {
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
	dc.setCapability(MobileCapabilityType.UDID,"220b6806");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
	dc.setCapability("appPackage", "com.androidsample.generalstore");
	dc.setCapability("appActivity", ".SplashActivity");
	
	
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, dc);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	MobileElement expand=(MobileElement) driver.findElementById("com.androidsample.generalstore:id/spinnerCountry");
	expand.tap(1, 500);
	scrolltoElement(driver,"text","India");
	}

	public static void scrolltoElement(AndroidDriver driver,String an,String av) {
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))");
}
}
