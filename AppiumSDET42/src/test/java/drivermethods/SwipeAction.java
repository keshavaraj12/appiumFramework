package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwipeAction {
@Test
public void swipeaction() throws MalformedURLException {
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
	dc.setCapability(MobileCapabilityType.UDID,"220b6806");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
	dc.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
	dc.setCapability("appActivity", ".TouchScreenTestActivity");
	
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, dc);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//  vertical line
//	driver.swipe(94, 297, 94, 1145, 500);
//	driver.swipe(370, 297, 370, 1145, 500);
//	driver.swipe(600, 297, 600, 1145, 500);
//	horizontal line
//	driver.swipe(94, 517, 615, 517, 500);
//	driver.swipe(94, 915, 615, 915, 500);
	
//	Dimension screen = driver.findElementById("jp.rallwell.siriuth.touchscreentest:id/surfaceView").getSize();
//	int h = screen.getHeight();
//	System.out.println(h);
//	int w = screen.getWidth();
//	System.out.println(w);
//	//vertical line
//	driver.swipe(w/5, 100, w/5, h, 500);
//	driver.swipe(w/2, 100, w/2, h, 500);
//	driver.swipe(w-100, 100, w-100, h, 500);
//	//horizontal line
//	driver.swipe(0, h/5, w, h/5, 500);
//	driver.swipe(0, h/2, w, h/2, 500);
//	driver.swipe(0,h-200, w, h-200, 500);
	
	Dimension screen = driver.findElementById("jp.rallwell.siriuth.touchscreentest:id/surfaceView").getSize();
	int h = screen.getHeight();
	System.out.println(h);
	int w = screen.getWidth();
	System.out.println(w);
	//vertical line
	driver.swipe(100, 100, 100, h-100, 500);
	driver.swipe(w/2, 100, w/2, h-100, 500);
	driver.swipe(w-100, 100, w-100, h-100, 500);
	//horizontal line
	driver.swipe(100, 100, w-100, 100, 500);
	driver.swipe(100, h/2, w-100, h/2, 500);
	driver.swipe(100, h-100, w-100, h-100, 500);
	
	
	
	
	
	
}
}
