package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class upstoxlogin2page
{
	//1st step:declaring variable globally with private using @FindBy Annotation
     @FindBy(xpath="//input[@id='yob']") private WebElement passcode;
     
     //2nd step: Initialize within a constructor with access level public using page factory class
     public upstoxlogin2page(WebDriver driver)
     {
    	 PageFactory.initElements(driver,this);
     }
     //3rd step: initialize within a method with access level public 
      public void passcd(String pin)
      {
    	 passcode.sendKeys(pin);
      }
}
