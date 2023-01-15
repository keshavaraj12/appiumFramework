package drivermethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OpenNotification {
	@Test
public void openNotification() throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
		dc.setCapability(MobileCapabilityType.UDID,"220b6806");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement app = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"App\"]");
		app.tap(1, 500);
		MobileElement notification = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Notification\"]");
		notification.tap(1, 500);
		MobileElement incomeingmessages = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"IncomingMessage\"]");
		incomeingmessages.tap(1, 500);
		MobileElement showappnotification = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"Show App Notification\"]");
		showappnotification.tap(1, 500);
		driver.openNotifications();
		driver.findElementByClassName("android.view.ViewGroup").click();

		
}
}
