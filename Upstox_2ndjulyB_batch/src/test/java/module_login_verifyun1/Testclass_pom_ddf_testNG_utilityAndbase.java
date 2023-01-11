package module_login_verifyun1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library_files1.login_pom_ddf_TestNG_Basecls;
import library_files1.login_pom_ddf_TestNG_Utilitycls;
import login1.login1page;
import login1.login2page;
import login1.login3page;
import login1.login4page;

public class Testclass_pom_ddf_testNG_utilityAndbase extends login_pom_ddf_TestNG_Basecls
{
	//WebDriver driver;
	login1page obj1;
	login2page obj2;
	login3page obj3;
	login4page obj4;
	int Testcaseid;
	@BeforeClass
	public void browseropen() throws IOException
	{
		initializebrowser();
		obj1=new login1page(driver);
		obj2=new login2page(driver);
		obj3=new login3page(driver);
		obj4=new login4page(driver);	
	}
	@BeforeMethod
	public void loginapp() throws EncryptedDocumentException, IOException
	{
	//	obj1.username(login_pom_ddf_TestNG_Utilitycls.getTD(0, 0));
		obj1.username(login_pom_ddf_TestNG_Utilitycls.getproperties("UN"));
		//obj1.PWD(login_pom_ddf_TestNG_Utilitycls.getTD(0, 1));
		obj1.PWD(login_pom_ddf_TestNG_Utilitycls.getproperties("PW"));
		obj1.click();
	 	
		//obj2.passcode(login_pom_ddf_TestNG_Utilitycls.getTD(0, 2));
		obj2.passcode(login_pom_ddf_TestNG_Utilitycls.getproperties("passcode"));
		obj3.welcomepage();
	}
	@Test
	public void verifyUID() throws EncryptedDocumentException, IOException
	{
		Testcaseid=204;
		String actid = obj4.verifyuid();
		//String expid = "tri";//login_pom_ddf_TestNG_Utilitycls.getTD(0, 3);
		String expid = "tri";//login_pom_ddf_TestNG_Utilitycls.getproperties("uid");
		Assert.assertEquals(actid, expid,"TC is passed");
	}
	
	@AfterMethod
	public void logout(ITestResult result) throws IOException, InterruptedException
	{
	 	if(result.getStatus()==result.FAILURE)
	 	{
	 		Thread.sleep(7000);
	 		login_pom_ddf_TestNG_Utilitycls.capturescreenshot(driver, Testcaseid);
	 	}
	 	driver.close();
	 	
	}
	@AfterClass
	public void browserclass()
	{
	 driver=null;
	 obj1=null;
	 obj2=null;
	 obj3=null;
	 obj4=null;
	}
}
