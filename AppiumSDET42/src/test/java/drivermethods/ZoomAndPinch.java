package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ZoomAndPinch {
@Test
	public void zoomAndpicch() throws MalformedURLException, Throwable {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
		dc.setCapability(MobileCapabilityType.UDID,"220b6806");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
		dc.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
		dc.setCapability("appActivity", ".MainActivity");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures")).click();
		WebElement image = driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/imageView"));
		driver.zoom(image);
		Thread.sleep(2000);
		driver.pinch(image);
		
		
	}
}
