package logout_module_verifyUN;

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

import logout.login1page;
import logout.login2page;
import logout.login3page;
import logout.login4page;
import logout_library_files.logout_pom_ddf_testNG_utilitycls;
import logout_library_files.logout_pom_ddf_testng_basecls;

public class Testclass_login_out_testNG extends logout_pom_ddf_testng_basecls
{
	//WebDriver driver;
	Sheet sh;
	login1page obj1;
	login2page obj2;
	login3page obj3;
	login4page obj4;
	int Testcaseid; 
	@BeforeClass
	public void browseropen() throws EncryptedDocumentException, IOException
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
		//obj1.username(logout_pom_ddf_testNG_utilitycls.getTD(0, 0));
		obj1.username(logout_pom_ddf_testNG_utilitycls.getproperties("UN"));
		//obj1.PWD(logout_pom_ddf_testNG_utilitycls.getTD(0, 1));
		obj1.PWD(logout_pom_ddf_testNG_utilitycls.getproperties("PW"));
		obj1.click();
		
		//obj2.passcode(logout_pom_ddf_testNG_utilitycls.getTD(0, 2));
		obj2.passcode(logout_pom_ddf_testNG_utilitycls.getproperties("passcode"));
		
		obj3.welcomepage();
	}
	@Test
	public void verifyun() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Testcaseid=154;
		String actid = obj4.verifyuid();
		//String expid =logout_pom_ddf_testNG_utilitycls.getTD(0, 3);
		String expid = logout_pom_ddf_testNG_utilitycls.getproperties("uid");
		Assert.assertEquals(actid, expid,"TC is passed");		
		Thread.sleep(3000);
	}
	@AfterMethod
	public void getScreenshot(ITestResult result) throws IOException, InterruptedException
	{
		if(result.getStatus()==result.SUCCESS)
		{
			Thread.sleep(3000);
			logout_pom_ddf_testNG_utilitycls.capturescreenshot(driver, Testcaseid);
		}
		
		obj4.logout();	
		Thread.sleep(3000);
		driver.quit();
	}
	@AfterClass()
	public void browserclose()
	{
		driver=null;
		sh=null;
		obj1=null;
		obj2=null;
		obj3=null;
		obj4=null;	
	}

}
