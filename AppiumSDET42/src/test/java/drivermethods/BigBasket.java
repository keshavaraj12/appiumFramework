package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BigBasket {
	@Test
public void bigbasket() throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
		dc.setCapability(MobileCapabilityType.UDID,"220b6806");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
		dc.setCapability("appPackage", "com.bigbasket.mobileapp");
		dc.setCapability("appActivity", ".activity.DoorSelectionActivity");
		dc.setCapability("noReset", true);
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("(//android.widget.ImageView[@content-desc='Bigbasket'])[1]").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//android.widget.ImageView[@resource-id='com.bigbasket.mobileapp:id/imgCategory'])[1]").click();
		Thread.sleep(5000);
		
		MobileElement fresh=(MobileElement) driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.bigbasket.mobileapp:id/imgCategory']");
		fresh.swipe(SwipeElementDirection.UP, 500);
		Thread.sleep(1000);
		driver.findElementByXPath("(//android.widget.ImageView[@resource-id='com.bigbasket.mobileapp:id/imgCategory'])[5]").click();
		Thread.sleep(3000);
		
			List<MobileElement> productName = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/txtProductDesc']"));
			for (MobileElement nameOptions : productName) {
				System.out.println(nameOptions.getText());
			nameOptions.swipe(SwipeElementDirection.UP, 500);
			}
			
		
		List<MobileElement> productPrice = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/txtSalePrice']"));
		for (MobileElement priceOptions : productPrice) {
			System.out.println(priceOptions.getText());
			priceOptions.swipe(SwipeElementDirection.UP, 500);
			
		}
}

}
