package Generics;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseClass {
	public static AppiumDriverLocalService service; 
    public static String NodeEXePath="C:\\Program Files\\nodejs\\node.exe";
    public static String NodeJsMainPath="C:\\Users\\HP\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
    public static String ServerAddress="0.0.0.0";
    
	public AndroidDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	
@BeforeSuite
public void data() {
	System.out.println("database connection");
	String timeStamp = LocalDateTime.now().toString().replace(':', '-');
    ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(new File("./ExtentReport/report["+timeStamp+"].html"));		
    htmlReport.config().setDocumentTitle("Extent Report");
    htmlReport.config().setTheme(Theme.STANDARD);
    htmlReport.config().setReportName("Functional Test");
    
    report=new ExtentReports();
    report.attachReporter(htmlReport);
    report.setSystemInfo("Platform", "Android");
    report.setSystemInfo("Reporter Name", "keshava");
}

@BeforeTest
public void parallel() {
	System.out.println("Execute parallel");
}

@BeforeClass
public void startserver() {
	System.out.println("Appium server started");
	String datetime = LocalDateTime.now().toString().replace(':', '-');
	service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
			.usingDriverExecutable(new File(NodeEXePath)).withAppiumJS(new File(NodeJsMainPath))
			.withIPAddress(ServerAddress)
			.withArgument(GeneralServerFlag.CONFIGURATION_FILE ,"wd/hub").usingPort(4723).withLogFile(new File("./AppiumLogs/AppiumServer Log file "+datetime+".txt")));

			service.start();			
}

@BeforeMethod
public void openApp(ITestResult result) throws Throwable {
	System.out.println("Open app");
	PropertyFile file= new PropertyFile();
	String platformname = file.propertyfile("platformName");
	String platformversion = file.propertyfile("platformVersion");
	String devicename = file.propertyfile("deviceName");
	String deviceid = file.propertyfile("deviceId");
	String automationname = file.propertyfile("automationName");
	String apppackage = file.propertyfile("appPackage");
	String appactivity = file.propertyfile("appActivity");
	
	DesiredCapabilities dc=new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformname);
	dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformversion);
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
	dc.setCapability(MobileCapabilityType.UDID, deviceid);
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationname);
	dc.setCapability("appPackage", apppackage);
	dc.setCapability("appActivity",appactivity );
	dc.setCapability("noReset", true);
	
	URL url=new URL("http://localhost:4723/wd/hub");
	driver=new AndroidDriver(url, dc);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	test=report.createTest(result.getMethod().getMethodName());
	test.log(Status.INFO, result.getMethod().getMethodName());
}

MobileDriverUtility mdu =new MobileDriverUtility();

@AfterMethod
public void closeapp(ITestResult result) throws IOException {
	if(result.getStatus()==ITestResult.FAILURE) {
		System.out.println("Take Screenshot "+result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
        test.log(Status.FAIL, result.getThrowable());
		try {
			String path = mdu.takeScreenshot(driver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}
				
	}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	}
	else if(result.getStatus()==ITestResult.SKIP) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");				
	    test.log(Status.SKIP, result.getThrowable());
	}
	
	System.out.println("Close app");
	driver.closeApp();
}

@AfterClass
public void stopserver() {
	System.out.println("Stop server");
	//service.stop();
}

@AfterTest
public void parallelclose() {
	System.out.println("close parallel execution");
}

@AfterSuite
public void closedata() {
	System.out.println("close database connection");
	report.flush();
}


}
