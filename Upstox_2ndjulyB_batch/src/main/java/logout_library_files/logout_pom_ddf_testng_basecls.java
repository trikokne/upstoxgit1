package logout_library_files;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class logout_pom_ddf_testng_basecls
{
	public WebDriver driver;
	public void initializebrowser() throws IOException
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\trimurti\\eclipse-workspace\\Upstox_2ndjulyB_batch\\browser\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		// driver.get("https://login-v2.upstox.com/");
	     driver.get(logout_pom_ddf_testNG_utilitycls.getproperties("URL")); 
	}

}
