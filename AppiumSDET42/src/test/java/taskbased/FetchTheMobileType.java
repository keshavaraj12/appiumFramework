package taskbased;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FetchTheMobileType {
	@Test
	public void fetchmobiletype() throws MalformedURLException, Throwable {
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
	dc.setCapability(MobileCapabilityType.UDID,"220b6806");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
	//dc.setCapability("appPackage", "com.androidsample.generalstore");
	//dc.setCapability("appActivity", ".SplashActivity");
	dc.setCapability("appPackage", "com.flipkart.android");
	dc.setCapability("appActivity", ".activity.HomeFragmentHolderActivity");
	dc.setCapability("noReset", true);
	
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, dc);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Set appslist = driver.getContextHandles();
	System.out.println(appslist);
	
	Thread.sleep(2000);
	}
}
