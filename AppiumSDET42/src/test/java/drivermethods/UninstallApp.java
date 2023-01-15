package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UninstallApp {
	@Test
public void uninstallapp() throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo 1724");
		dc.setCapability(MobileCapabilityType.UDID, "220b6806");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
		//dc.setCapability("appPackage", "io.appium.android.apis");
		//dc.setCapability("appActivity", ".ApiDemos");
		//dc.setCapability(MobileCapabilityType.FULL_RESET, true);
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.removeApp("io.appium.android.apis");
		//driver.removeApp("jp.rallwell.siriuth.touchscreentest");
		//driver.removeApp("com.androidsample.generalstore");
		
		boolean validateuninstall = driver.isAppInstalled("io.appium.android.apis");
		//boolean validateuninstall = driver.isAppInstalled("jp.rallwell.siriuth.touchscreentest");
		//boolean validateuninstall = driver.isAppInstalled("com.androidsample.generalstore");
		if(validateuninstall==false) {
			System.out.println("Expected app is uninstalled");
		}else {
			System.out.println("Expected app is not uninstalled");
		}

}
}
