package taskbased;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Flipkart {
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
	
	driver.findElementByXPath("//android.widget.TextView[@text='Search for products']").click();
	MobileElement search = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@text='Search for Products, Brands and More']");
	search.sendKeys("iphone 14 pro");
	Thread.sleep(2000);
	driver.hideKeyboard();
	Thread.sleep(1000);
	List<WebElement> list = driver.findElementsByXPath("//android.widget.TextView[contains(@text,'iphone')]");
	for (int i = 0; i <list.size(); i++) {
		System.out.println(list.get(i).getText());
		Thread.sleep(1000);
	}
	Thread.sleep(3000);
	driver.findElementByXPath("//android.widget.TextView[@text='iphone 14 pro']").click();
	TouchAction tc=new TouchAction(driver);
	
	for(;;) {
		List<MobileElement> text = (List<MobileElement>) driver.findElementsByXPath("//android.widget.TextView[contains(@text,'APPLE') or contains(@text,'GB')]");
		List<MobileElement> price = (List<MobileElement>) driver.findElementsByXPath("//android.widget.TextView[contains(@text,'₹')]");
	for (int j = 0; j <text.size(); j++) {
		System.out.println(text.get(j).getText()+"-->"+price.get(j).getText().replace('₹', ' '));
					}
	tc.longPress(100, 1200,100).moveTo(100, 120).release().perform();
		}
	
	//driver.closeApp();
}
}
