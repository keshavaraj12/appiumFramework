package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DragAndDrop {
	@Test
public void name() throws MalformedURLException, Throwable {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
		dc.setCapability(MobileCapabilityType.UDID,"220b6806");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement view = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]");
		view.tap(1, 500);
		MobileElement draganddap=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]");
		draganddap.tap(1, 500);
		MobileElement src = (MobileElement) driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		src.tap(1, 500);
		Thread.sleep(1000);
		MobileElement dst = (MobileElement) driver.findElementById("io.appium.android.apis:id/drag_dot_hidden");
		TouchAction action= new TouchAction(driver);
		action.longPress(src).moveTo(dst).release().perform();
		
		
		
}
}
