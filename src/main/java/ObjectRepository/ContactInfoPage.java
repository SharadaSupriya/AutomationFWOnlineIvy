package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility {
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
     private WebElement ContactHeaderText;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//getter method
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}


	public String getContactHeader()
	{
	return ContactHeaderText.getText();	
	}
	
}
