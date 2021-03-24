package Tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Utilities.Readconfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Baseclass 
{
	Readconfig readconfig = new Readconfig();
	public String username= readconfig.getusername();
	public String password=readconfig.getpassword();
	public static AndroidDriver<AndroidElement> driver;
	public static Logger log;
@BeforeClass
	public static void Open_App() throws MalformedURLException 
	 {
	 DesiredCapabilities cap = new DesiredCapabilities();	
	 cap.setCapability("deviceName", "Android Emulator");
	 cap.setCapability("platformName", "Android");
	 cap.setCapability("appPackage", "com.psi.residentportal");
	 cap.setCapability("appActivity", "com.psi.residentportal.modules.splashscreen.view.SplashScreenActivity");
	 URL url=new URL("http://127.0.0.1:4723/wd/hub");
	 driver=new AndroidDriver<AndroidElement>(url,cap);
	 System.out.println("App opened succesfuly");
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 log=Logger.getLogger(Baseclass.class);
	 PropertyConfigurator.configure("log4j.properties");
	 
	 }

@AfterClass
	public static void Close_App()
	{
		driver.quit();
	}
public void capturescreen(WebDriver driver,String tname) throws IOException
{
TakesScreenshot sc=(TakesScreenshot) driver;

File source=sc.getScreenshotAs(OutputType.FILE);
File target=new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
FileUtils.copyFile(source,target);
System.out.println("Screenshot captured");
}

}
