package generalstore;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generics.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pomClasses.LoginGeneralStore;

public class GeneralstoreLoginTest extends BaseClass {
	@Test
	public void LoginTest() throws MalformedURLException, InterruptedException {
	
	LoginGeneralStore lg=new LoginGeneralStore(driver);
	Thread.sleep(2000);
	lg.loginpage("raju");
	//Assert.fail();
	
	}
}
