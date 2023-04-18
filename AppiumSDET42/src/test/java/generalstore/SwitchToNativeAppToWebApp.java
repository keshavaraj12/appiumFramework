package generalstore;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Generics.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import pomClasses.LoginGeneralStore;

public class SwitchToNativeAppToWebApp extends BaseClass {
@Test
	public void webapp() throws InterruptedException{
	LoginGeneralStore lg=new LoginGeneralStore(driver);
	Thread.sleep(2000);
	lg.loginpage("raju");

	driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();
	Thread.sleep(1000);
	driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
	Thread.sleep(1000);
	driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
	Thread.sleep(2000);
	Set<String> windows=driver.getContextHandles();
	for (String window : windows) {
		System.out.println("Active Applications : "+window);
	}
	
	driver.context("WEBVIEW_com.androidsample.generalstore");
	WebElement textfield = driver.findElementByXPath("//input[@name='q']");
	textfield.sendKeys("appium inspector");
	Thread.sleep(3000);
	List<MobileElement> suggession = (List<MobileElement>)driver.findElementsByXPath("//div[@id='tsuid_5']//div//ul[@role='listbox']//li//div[@class='s49v2']//span");
	for (int i = 0; i < suggession.size(); i++) {
		System.out.println(suggession.get(i).getText());
	}
	Thread.sleep(3000);
	textfield.sendKeys(Keys.ENTER);
	
	TouchAction ta=new TouchAction(driver);
	for (int i = 0; i <2; i++) {
		ta.longPress(100, 1200, 100).moveTo(100, 200).release().perform();
	}
	Thread.sleep(3000);
	driver.findElementByXPath("//div[@class='y0NFKc']//span[@class='wbJOMb']//div[.='GitHub']").click();
	
	Thread.sleep(3000);
	driver.closeApp();
	}
}
