package apiDemos;

import org.testng.annotations.Test;

import Generics.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class ApiDemos_dragAndDropWithBaseclass extends BaseClass{
	@Test
public void draganddropTest() throws InterruptedException {
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
	
//	driver.findElementByXPath("//android.widget.TextView[@text='winter heater']").click();
//	Thread.sleep(3000);
//	driver.findElementByXPath("//android.widget.TextView[@index='1']").click();
//	Thread.sleep(3000);
//	driver.findElementByXPath("//android.widget.TextView[@text='Add to cart']").click();
//	driver.pressKeyCode(AndroidKeyCode.BACK);
//	driver.findElementById("com.flipkart.android:id/cart_bg_icon").click();
//	
//	
//	Thread.sleep(3000);
//	String title = driver.findElement(By.xpath("//android.widget.TextView[@text='Aervinten Fan Heater for Room in Winter Noiseless Smart Room Heater Overheat Protector & Best for Child Safety Heat Air Blower || 1 Season Warranty Adjustable Fan Speed || Model- PL - M@rcury || Fan Room Heater ']")).getText();
//    Assert.assertTrue(title.contains("Aervinten"));
//    Thread.sleep(3000);
}
}
