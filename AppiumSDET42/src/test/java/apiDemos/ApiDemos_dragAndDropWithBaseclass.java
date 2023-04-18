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
	
	
}
}
