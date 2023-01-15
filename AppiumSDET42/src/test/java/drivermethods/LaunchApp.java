package drivermethods;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Generics.PropertyFile;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchApp {
	@Test
public void launchapp() throws Throwable {
		PropertyFile file= new PropertyFile();
		String platformname = file.propertyfile("platformName");
		String platformversion = file.propertyfile("platformVersion");
		String devicename = file.propertyfile("deviceName");
		String deviceid = file.propertyfile("deviceId");
		String automationname = file.propertyfile("automationName");
		String apppackage = file.propertyfile("appPackage1");
		String appactivity = file.propertyfile("appActivity1");

		
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformversion);
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
	dc.setCapability(MobileCapabilityType.UDID, deviceid);
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationname);
	dc.setCapability("appPackage", apppackage);
	dc.setCapability("appActivity",appactivity );
	
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url,dc);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//driver.launchApp();
	driver.closeApp();
		
}
}
