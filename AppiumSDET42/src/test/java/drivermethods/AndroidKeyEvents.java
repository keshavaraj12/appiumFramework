package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidKeyEvents {
@Test
	public void androidkeyevents() throws MalformedURLException, Throwable {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
		dc.setCapability(MobileCapabilityType.UDID,"220b6806");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.android.camera");
		dc.setCapability("appActivity", ".Camera");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_UP);
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		System.out.println(AndroidKeyCode.BACK);
		System.out.println(AndroidKeyCode.ENTER);
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		driver.openNotifications();
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(2000);
		
	}
}
