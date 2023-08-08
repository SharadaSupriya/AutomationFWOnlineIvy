package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class OrgInfoPage extends WebDriverUtility{
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement OrgHeaderText;
	
	public OrgInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	
/**
 * This method will capture the header text and return it to caller
 * @return
 */
	public String getHeaderText()
	{
		return OrgHeaderText.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
