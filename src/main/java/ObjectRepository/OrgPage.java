package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	
	@FindBy(xpath="//img[@title=\"Create Organization...\"]")
    private WebElement CreateOrgLookUpIcon;
	
	
	public OrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
  
    public WebElement getCreateOrgLookUpIcon() {
		return CreateOrgLookUpIcon;
	}


	public void ClickonCreateOrgLookUpIcon()
	{
		
		CreateOrgLookUpIcon.click();
	}
    }
	