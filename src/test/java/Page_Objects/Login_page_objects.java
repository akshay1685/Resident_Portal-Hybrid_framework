package Page_Objects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tests.Baseclass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login_page_objects extends Baseclass
{
	
	public Login_page_objects(AndroidDriver<AndroidElement> driver) 
	{
	PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}//Constructor created to be called by test case
	
	@FindBy (id= "com.psi.residentportal:id/edtBase")
	private AndroidElement username;
	
	@FindBy (xpath= "//android.view.View[contains(@content-desc,'Password')]")
	AndroidElement password;
	
	@FindBy (id= "com.psi.residentportal:id/btnLogin")
	AndroidElement loginbutton;
	
	@FindBy(id="com.psi.residentportal:id/txtTitle")
	AndroidElement titletext;
	
	/*@FindBy (xpath= "//android.view.View[contains(text(),'Hogwarts')]")
	AndroidElement property1;
	
	@FindBy (xpath= "//android.view.View[contains(text(),'Resident Portal app')]")
	AndroidElement property2;*/
	
	@FindBy (id= "com.psi.residentportal:id/btnContinue")
	AndroidElement continuebutton;
	
	@FindBy (xpath= "//android.widget.FrameLayout[contains(@content-desc,'Main Menu')]")
	AndroidElement mainmenu;
	
	@FindBy (id= "com.psi.residentportal:id/incLogout")
	AndroidElement logout;


	public void setusername(String uname)
	{
	    username.clear();
		username.sendKeys(uname);
	}
	public void setpassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickloginbutton()
	{
		loginbutton.click();
	}
	
	public String returntext()
	{
		return titletext.getText();
	}
	/*public String property1()
	{
		return property1.getText();
	}
	public String property2()
	{
		return property2.getText();
	}*/
	public void clickcontinuebutton()
	{
		continuebutton.click();
	}
	public void clickmainmenu()
	{
		mainmenu.click();
	}
	public void clicklogout()
	{
		logout.click();
	}

	
}
