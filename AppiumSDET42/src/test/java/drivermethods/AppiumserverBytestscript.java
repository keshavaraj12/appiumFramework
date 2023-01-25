package drivermethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumserverBytestscript {
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service; 

    public static String NodeEXePath="C:\\Program Files\\nodejs\\node.exe";
    
    public static String NodeJsMainPath="C:\\Users\\HP\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
    
    public static String ServerAddress="0.0.0.0";
    
    @BeforeClass
    public void appiumserverstart() {
    	String datetime = LocalDateTime.now().toString().replace(':', '-');
    	service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
    			.usingDriverExecutable(new File(NodeEXePath)).withAppiumJS(new File(NodeJsMainPath))
    			.withIPAddress(ServerAddress)
    			.withArgument(GeneralServerFlag.CONFIGURATION_FILE ,"wd/hub").usingPort(4723).withLogFile(new File("./AppiumLogs/AppiumServer Log file "+datetime+".txt")));
    
    			service.start();
    			System.out.println("Appium server started");
	}
    @Test
    public void testscript() throws MalformedURLException, InterruptedException {
    	DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
		dc.setCapability(MobileCapabilityType.UDID,"220b6806");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement view = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]");
		view.tap(1, 500);
		MobileElement draganddap=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]");
		draganddap.tap(1, 500);
		MobileElement src = (MobileElement) driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		src.tap(1, 500);
		Thread.sleep(500);
		MobileElement dst = (MobileElement) driver.findElementById("io.appium.android.apis:id/drag_dot_hidden");
		TouchAction action= new TouchAction(driver);
		action.longPress(src).moveTo(dst).release().perform();
		Thread.sleep(500);
		driver.closeApp();
	}
    @AfterClass
    public void appiumserverstop() {
    	//service.stop();
	}
}
