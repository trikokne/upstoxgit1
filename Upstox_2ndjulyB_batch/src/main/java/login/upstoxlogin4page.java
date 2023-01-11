package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class upstoxlogin4page 
{
	//1st step: declaration of variable globally with access level private using @FindBy annotation
	@FindBy(xpath="//span[text()='trimurti k.']") private WebElement usrnm;
	
	//2nd step: initialize within a constructor with access level public using PageFactory class
	public upstoxlogin4page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//3rd step: utilize within a method using access level public
	/*public void username(String usrid)
	{
		String expid = "Trimurti K.";
		boolean result = expid.equals(usrid);
		if(result)
		{
			System.out.println("user is valid"+"="+result);
		}
		else 
		{
			System.out.println("user is not valid"+"="+result);
		}*/
	  public String VUID()
	  {
		  String username = usrnm.getText();
		  return username;
	  }
		
		
	

}
