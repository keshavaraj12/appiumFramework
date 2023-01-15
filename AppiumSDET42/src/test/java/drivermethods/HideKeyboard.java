package drivermethods;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class HideKeyboard {
	@Test
public void hidekeyboard() throws Throwable {
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
		MobileElement controls = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Controls\"]");
		controls.tap(1, 500);
		MobileElement lightTheme = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]");
		lightTheme.tap(1, 500);
		MobileElement textfield = (MobileElement) driver.findElementById("io.appium.android.apis:id/edit");
		textfield.tap(1, 500);
		textfield.sendKeys("raju");
		driver.hideKeyboard();
		MobileElement checkbox1 = (MobileElement) driver.findElementById("io.appium.android.apis:id/check1");
		checkbox1.tap(1, 500);
		MobileElement checkbox2 = (MobileElement) driver.findElementById("io.appium.android.apis:id/check2");
		checkbox2.tap(1, 500);
		MobileElement radio1 = (MobileElement) driver.findElementById("io.appium.android.apis:id/radio1");
		radio1.tap(1, 500);
		MobileElement star = (MobileElement) driver.findElementById("io.appium.android.apis:id/star");
		star.tap(1, 500);
		MobileElement off1 = (MobileElement) driver.findElementById("io.appium.android.apis:id/toggle1");
		off1.tap(1, 500);
		MobileElement expand = (MobileElement) driver.findElementById("io.appium.android.apis:id/spinner1");
		expand.tap(1, 500);
		List<MobileElement> alloptions = driver.findElementsByClassName("android.widget.CheckedTextView");
		for (WebElement printOptions : alloptions) {
			System.out.println(printOptions.getText());
		}
		   
}
}
