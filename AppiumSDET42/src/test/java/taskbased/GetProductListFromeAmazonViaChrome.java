package taskbased;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GetProductListFromeAmazonViaChrome {
	@Test
public void getproduct() throws MalformedURLException, InterruptedException {
	//chrome://inspect/#devices
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
	dc.setCapability(MobileCapabilityType.UDID,"220b6806");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
	dc.setBrowserName("Chrome");
	dc.setCapability("noReset", true);
			
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, dc);		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.amazon.in/");
	
	driver.findElement(By.xpath("//div[@class='nav-search-field']//input")).sendKeys("iphone 13");
	Thread.sleep(3000);
	List<WebElement> prod = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
	System.out.println(prod.size());
	Thread.sleep(3000);
	
	for (int i = 0; i < prod.size(); i++) {
		System.out.println(prod.get(i).getText());
		Thread.sleep(2000);
	}
	
	 System.out.println("firstproduct -->"+prod.get(0).getText());
	 System.out.println("secondproduct -->"+prod.get(1).getText());
	System.out.println("lastproduct -->"+prod.get(prod.size()-1).getText());
	Thread.sleep(3000);
	
	for (int i = 0; i < prod.size(); i++) {
		if(i%2==0) {
		System.out.println(prod.get(i).getText());
		Thread.sleep(2000);
	}
	}
	
	
	driver.closeApp();
			
	driver.quit();
	
	}
}
