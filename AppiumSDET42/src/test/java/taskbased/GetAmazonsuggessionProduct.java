package taskbased;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GetAmazonsuggessionProduct {
	@Test
public void getproduct() throws MalformedURLException, InterruptedException {
		
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
	dc.setCapability(MobileCapabilityType.UDID,"220b6806");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
	//in.amazon.mShop.android.shopping/com.amazon.mShop.home.HomeActivity
	dc.setCapability("appPackage", "in.amazon.mShop.android.shopping");
	dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
	dc.setCapability("noReset", true);
			
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, dc);		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElementById("in.amazon.mShop.android.shopping:id/chrome_search_hint_view").click();
	driver.findElementById("in.amazon.mShop.android.shopping:id/rs_search_src_text").sendKeys("iphone 13");
	Thread.sleep(3000);
	List<MobileElement> product = driver.findElementsByXPath("//android.widget.Button[contains(@text,'iphone')]");
	System.out.println(product.size());
	Thread.sleep(2000);
	for (MobileElement text : product) {
		System.out.println(text.getText());
		Thread.sleep(2000);
	}
	
	 System.out.println("firstproduct -->"+product.get(0).getText());
	 System.out.println("secondproduct -->"+product.get(1).getText());
	System.out.println("lastproduct -->"+product.get(product.size()-1).getText());
	
	Thread.sleep(3000);
	driver.closeApp();
}
}
