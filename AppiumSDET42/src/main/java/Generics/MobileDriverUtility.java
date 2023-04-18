package Generics;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MobileDriverUtility {
	TouchAction tc;
	AndroidDriver driver;
	
public void tapactionsByElement(int fingers,MobileElement element,int duration) {
	driver.tap(fingers, element, duration);
}	

public void tapactionsByCoordinates(int fingers ,int x,int y,int duration) {
	driver.tap(fingers, x, y, duration);;
}	

public void swipactionsByCoordinates(int startx,int starty,int endx,int endy,int duration) {
	driver.swipe(startx, starty, endx, endy, duration);;
}	

public void scrollElement(AndroidDriver driver,String an,String av ) {
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\")");
}

public void dragandrop(MobileElement src,MobileElement dest) {
	tc=new TouchAction(driver);
	tc.longPress(src).waitAction().moveTo(dest).perform().release();
}	

public String takeScreenshot(AndroidDriver driver,String result) throws IOException {
String timeStamp = LocalDateTime.now().toString().replace(':', '-');
String testname = result;
TakesScreenshot sc=(TakesScreenshot) driver;
File srcfile=sc.getScreenshotAs(OutputType.FILE);
File destfile=new File("./ScreenShots/"+timeStamp+testname+" .png");
FileUtils.copyFile(srcfile, destfile);
return destfile.getAbsolutePath();

}

}
