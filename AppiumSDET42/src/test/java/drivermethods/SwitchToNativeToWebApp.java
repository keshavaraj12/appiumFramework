package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwitchToNativeToWebApp {
@Test
	public void webapp() throws MalformedURLException, Throwable {
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
	driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("raju");
	driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();
	Thread.sleep(1000);
	driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
	Thread.sleep(1000);
	driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
	Thread.sleep(2000);
	Set<String> windows=driver.getContextHandles();
	for (String window : windows) {
		System.out.println("Active Applications : "+window);
	}
	
	driver.context("WEBVIEW_com.androidsample.generalstore");
	WebElement textfield = driver.findElementByXPath("//input[@name='q']");
	textfield.sendKeys("appium");
	textfield.sendKeys(Keys.ENTER);	
	
	
	}
}
