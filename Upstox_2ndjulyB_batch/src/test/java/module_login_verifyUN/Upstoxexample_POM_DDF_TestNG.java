package module_login_verifyUN;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library_files.POM_DDF_TestNG_Baseclass;
import library_files.POM_DDF_TestNG_Utilityclass;
import login.upstoxlogin1page;
import login.upstoxlogin2page;
import login.upstoxlogin3page;
import login.upstoxlogin4page;


public class Upstoxexample_POM_DDF_TestNG extends POM_DDF_TestNG_Baseclass
{
	//WebDriver driver;
	Sheet sh;
	upstoxlogin1page obj1;
	upstoxlogin2page obj2;
	upstoxlogin3page obj3;
	upstoxlogin4page obj4;
	int TestcaseID;
	
	@BeforeClass
	public void browseropen() throws EncryptedDocumentException, IOException
	{
		initializebrowser();
		obj1=new upstoxlogin1page(driver);
		obj2=new upstoxlogin2page(driver);
		obj3=new upstoxlogin3page(driver);
		obj4=new upstoxlogin4page(driver);	
	}
	@BeforeMethod
    public void login() throws EncryptedDocumentException, IOException, InterruptedException
   	{
	 // obj1.enterUN(POM_DDF_TestNG_Utilityclass.getTD(0, 0));
		obj1.enterUN(POM_DDF_TestNG_Utilityclass.getproeprtiesfile("UN"));
	  //obj1.enterPW(POM_DDF_TestNG_Utilityclass.getTD(0, 1));
		obj1.enterPW(POM_DDF_TestNG_Utilityclass.getproeprtiesfile("PWD"));
	    obj1.clickon();	

	  //obj2.passcd(POM_DDF_TestNG_Utilityclass.getTD(0, 2));
	  obj2.passcd(POM_DDF_TestNG_Utilityclass.getproeprtiesfile("Passcode"));
	
	  obj3.welcome();
   	}
   @Test
   public void verifyUN() throws EncryptedDocumentException, IOException
    {
	   TestcaseID=500;
	  String actid = obj4.VUID();
	  String expid = "tri";//POM_DDF_TestNG_Utilityclass.getTD(0, 3);
	  Assert.assertEquals(actid, expid);
    }
   @AfterMethod
	public void logout(ITestResult result) throws IOException
	{
	  if(result.getStatus()==result.FAILURE)
	  {
		  POM_DDF_TestNG_Utilityclass.capturescreenshot(driver, TestcaseID);
	  }
	}
   @AfterClass
   public void browserclose()
   {
	   //driver.close();
	   obj1=null;
	   obj2=null;
	   obj3=null;
	   obj4=null;
	   driver=null;
	   sh=null; 
   }
}
