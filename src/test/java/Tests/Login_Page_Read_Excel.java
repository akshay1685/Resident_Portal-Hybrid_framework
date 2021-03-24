package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page_Objects.Login_page_objects;
import Utilities.XLUtils;

public class Login_Page_Read_Excel extends Baseclass
{
	 @Test(dataProvider="LoginData")
		 public void Login_data(String username,String password) throws InterruptedException, IOException
		 {
		 Login_page_objects lpo=new Login_page_objects(driver);
		
		 lpo.setusername(username);
		 log.info("Got username");

		 lpo.setpassword(password);
		 log.info("Got pass");

		 lpo.clickloginbutton();
		 log.info("Got clicked");

		 Thread.sleep(5000);
		 String title= lpo.returntext();
		 System.out.println(title);
		 log.info("Got Title");
		 //String property1= lpo.property1();
		// String property2= lpo.property1();
		// System.out.println(property1);
		// System.out.println(property2);
		 if(title.equals("Select Your Property"))
		 {
			 Assert.assertTrue(true);
			 lpo.clickcontinuebutton();
			 System.out.println("Logged in");
			 lpo.clickmainmenu();
			 lpo.clicklogout();

		 }
		 else{
			 capturescreen(driver , "Login_page_read_excel");
			 System.out.println("Login failed");

			 Assert.assertTrue(false);
		 }
	     }
	 
	 @DataProvider(name="LoginData")
	  String[][] getdata() throws IOException, InterruptedException
	 {
		 String path=System.getProperty("user.dir")+"/src/test/java/Testdata/LoginData.xlsx";
		 int rownum=XLUtils.getRowCount(path,"sheet1");
		 int colnum=XLUtils.getCellCount(path,"sheet1",1);
		 String logindata[][] = new String[rownum][colnum];
		 for (int i=1;i<=rownum;i++)
		 {
			 for (int j=0;j<colnum;j++)
			 {
				 logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);

			 }
		 }
		 return logindata;
	 }
	
}
