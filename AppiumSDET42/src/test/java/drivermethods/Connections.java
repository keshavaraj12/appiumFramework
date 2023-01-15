package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.remote.MobileCapabilityType;

public class Connections {
@Test
	public void connection() throws MalformedURLException, Throwable {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
		dc.setCapability(MobileCapabilityType.UDID,"220b6806");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
		//dc.setCapability("appPackage", "io.appium.android.apis");
		//dc.setCapability("appActivity", ".ApiDemos");
		
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Connection currentworkconnection = driver.getConnection();
		System.out.println(currentworkconnection);
		driver.setConnection(currentworkconnection.WIFI);
		Thread.sleep(1000);
		driver.setConnection(currentworkconnection.AIRPLANE);
		Thread.sleep(1000);
		driver.setConnection(currentworkconnection.DATA);
		Thread.sleep(1000);
		//celluor connection
		driver.setConnection(currentworkconnection.ALL);
		Thread.sleep(1000);
		driver.setConnection(currentworkconnection.NONE);
	}
}
