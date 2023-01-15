package pomClasses;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginGeneralStore {
	
	private AndroidDriver<AndroidElement> driver;
	
	public LoginGeneralStore(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private MobileElement usernametextfield;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private MobileElement maleradiobutton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private MobileElement femaleradiobutton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private MobileElement letsshopbutton;

	public MobileElement getUsernametextfield() {
		return usernametextfield;
	}

	public MobileElement getMaleradiobutton() {
		return maleradiobutton;
	}

	public MobileElement getFemaleradiobutton() {
		return femaleradiobutton;
	}

	public MobileElement getLetsshopbutton() {
		return letsshopbutton;
	}
	
	public void loginpage(String name) {
		usernametextfield.sendKeys(name);
		maleradiobutton.click();
		letsshopbutton.click();
		
	}
	 
}
