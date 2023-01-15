package drivermethods;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScreenShot {
	@Test
	public void toast() throws IOException {
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo 1724");
	dc.setCapability(MobileCapabilityType.UDID,"220b6806");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
	dc.setCapability("appPackage", "com.androidsample.generalstore");
	dc.setCapability("appActivity", ".SplashActivity");
	
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, dc);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	String value = driver.findElementByXPath("//android.widget.Toast[1]").getText();
	System.out.println(value);
	
	//SoftAssert sf=new SoftAssert();
	//sf.assertTrue(false);
	
	Assert.assertTrue(false);
	
	String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	TakesScreenshot ts = (TakesScreenshot)driver;
	File tempFile = ts.getScreenshotAs(OutputType.FILE);
	File destinationFile = new File("./Screenshots/failure/"+timeStamp+".png");
	FileUtils.copyFile(tempFile,destinationFile );
	
	//sf.assertAll();

	}
}
