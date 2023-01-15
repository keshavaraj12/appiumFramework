package drivermethods;


import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BrowserStackSample {
@Test
	public void browserstack() throws Throwable
	{
	DesiredCapabilities ds = new DesiredCapabilities();
	
	ds.setCapability("browserstack.user", "keshavaraj_LxpJA3");
	ds.setCapability("browserstack.key", "GPfd3yNZDPi7DujQkLbE");
	
	ds.setCapability("app", "bs://67fcd7593a4cc80f82b896e79f2887e2c2a4ca29");

    ds.setCapability("device", "Google Pixel 3");
    ds.setCapability("os_version", "9.0");
    
	ds.setCapability("project", "First Java Project");
	ds.setCapability("build", "browserstack-build-1");
	ds.setCapability("name", "first_test");
   
    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
    		new URL("http://hub.browserstack.com/wd/hub"), ds);
    
    driver.quit();
	
}
}
