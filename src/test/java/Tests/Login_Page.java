package Tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import Page_Objects.Login_page_objects;

public class Login_Page extends Baseclass
{
 @Test
	 public void Login_test() throws InterruptedException, IOException
	 {	
	 Login_page_objects lpo = new Login_page_objects(driver);
	 lpo.setusername(username);
	 System.out.println(username);
	 log.info("Got username");
	 
	 lpo.setpassword(password);
	 System.out.println(password);
	 log.info("Got pass");

	 lpo.clickloginbutton();
	 log.info("Got clicked");

	 Thread.sleep(10000);
	 String title= lpo.returntext();
	 System.out.println(title);
	 log.info("Got Title");


	 if(title.equals("Select Your Property"))
	 {
		 Assert.assertTrue(true);
	 }
	 else{
		 capturescreen(driver , "Login_test");
		 Assert.assertTrue(false);
	 }
	 }
 }
	
 

