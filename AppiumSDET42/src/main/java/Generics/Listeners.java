package Generics;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.appium.java_client.android.AndroidDriver;

public class Listeners implements ITestListener{

AndroidDriver pdriver;
public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
	}
	
	//for taking screenshot for failure
	public void onTestFailure(ITestResult result) {
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		String testname = result.getMethod().getMethodName();
		System.out.println(testname+"Take ScreenShot");	
		File srcfile=pdriver.getScreenshotAs(OutputType.FILE);
		try {
			File destfile=new File("./ScreenShots/"+timeStamp+"+"+testname+".png");
			FileUtils.copyFile(srcfile, destfile);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}


	public void onTestSkipped(ITestResult result) {
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
			}

	public void onStart(ITestContext context) {
			}

	public void onFinish(ITestContext context) {
	}

}
