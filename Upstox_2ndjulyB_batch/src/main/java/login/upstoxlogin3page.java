package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class upstoxlogin3page 
{
	//1st step: declaration of variable globally with access level private using @FindBy annotation
    @FindBy(xpath="//div[text()='No, I’m good']")private WebElement WC;
    
    //2nd step: initialize within a constructor with access level public using PageFactory class
    public upstoxlogin3page(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    //3rd step: utilize within the method with access level public
    public void welcome()
    {
    	WC.click();
    }
}
