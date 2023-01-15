package drivermethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ZoomActions {
	
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, Throwable {
		AppiumDriverLocalService service= AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.usingPort(4724));
		
		service.start();
		

		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
		dc.setCapability(MobileCapabilityType.UDID,"220b6806");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
		dc.setCapability("appActivity", ".MainActivity");
		
		
		URL url=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(url, dc);
		AppiumDriver driver=new AndroidDriver(url,dc);
		//AppiumDriver driver1=new IOSDriver(url,dc);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures")).click();
		WebElement image = driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/imageView"));
		driver.zoom(image);
		Thread.sleep(2000);
		driver.pinch(image);
		//service.stop();
		

	}

}
