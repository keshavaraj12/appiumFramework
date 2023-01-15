package drivermethods;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserStackParallel {
	@Parameters({"devicename","platformversion"})
	@Test
	public void browserstackparallel(String devicename,String platformversion) throws Throwable
	{
	DesiredCapabilities ds = new DesiredCapabilities();
	
	ds.setCapability("browserstack.user", "keshavaraj_LxpJA3");
	ds.setCapability("browserstack.key", "GPfd3yNZDPi7DujQkLbE");
	
	//bs://14daefee7559fe06a3ecdccc4c5f080db74985b7 //touchscreen
	//bs://67fcd7593a4cc80f82b896e79f2887e2c2a4ca29 //for api demo
	ds.setCapability("app", "bs://27571d24c9848b12345bc4b661d42b7d75d8ebf2");

    ds.setCapability("device", devicename);
    ds.setCapability("os_version", platformversion);
    
	ds.setCapability("project", "First Java Project");
	ds.setCapability("build", "browserstack-build-1");
	ds.setCapability("name", "first_test");
   
    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
    		new URL("http://hub.browserstack.com/wd/hub"), ds);
    
    driver.quit();
	
}
}
