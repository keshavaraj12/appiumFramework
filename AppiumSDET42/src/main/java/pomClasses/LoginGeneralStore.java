package pomClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class LoginGeneralStore {
	
	private AppiumDriver driver;
	
	public LoginGeneralStore(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement usernametextfield;
	
	@FindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleradiobutton;
	
	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleradiobutton;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsshopbutton;

	public WebElement getUsernametextfield() {
		return usernametextfield;
	}

	public WebElement getMaleradiobutton() {
		return maleradiobutton;
	}

	public WebElement getFemaleradiobutton() {
		return femaleradiobutton;
	}

	public WebElement getLetsshopbutton() {
		return letsshopbutton;
	}
	
	public void loginpage(String name) {
		usernametextfield.sendKeys(name);
		maleradiobutton.click();
		letsshopbutton.click();
		
	}
	 
}
