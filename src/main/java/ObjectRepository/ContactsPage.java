package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
  @FindBy(xpath="//img[@title=\"Create Contact...\"]")
	private WebElement CreateContactLookUpIcon;
  
  
  //initialization  
    public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

      //utilization
	public WebElement getCreateContactLookUpIcon() {
		return CreateContactLookUpIcon;
	}
	
    //business Library
	/**
	 * This method will click on create contact look up image
	 */
    public void ClickOnCreateContactLookUpIcon()
    {
    	CreateContactLookUpIcon.click();
    }
	
	
   
}
