package taskbased;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwitchToNativeAppToWebApp {
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
	dc.setCapability("noReset", true);
	
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
	textfield.sendKeys("appium inspector");
	Thread.sleep(5000);
	List<MobileElement> suggession = (List<MobileElement>)driver.findElementsByXPath("//div[@id='tsuid_5']//div//ul[@role='listbox']//li//div[@class='s49v2']//span");
	for (int i = 0; i < suggession.size(); i++) {
		System.out.println(suggession.get(i).getText());
	}
	Thread.sleep(5000);
	textfield.sendKeys(Keys.ENTER);
	TouchAction ta=new TouchAction(driver);
	for (int i = 0; i <2; i++) {
		ta.longPress(100, 1200, 100).moveTo(100, 120).release().perform();
	}
	driver.findElementByXPath("//div[@class='y0NFKc']//span[@class='wbJOMb']//div[.='GitHub']").click();
	
	
	
	}
}
