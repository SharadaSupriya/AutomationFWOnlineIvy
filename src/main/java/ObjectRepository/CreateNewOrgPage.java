package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility{
	

	@FindBy(xpath="//input[@name=\"accountname\"]")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement  industryDropDown ;
	
	@FindBy(xpath="//input[@value=\"T\"]")
	private WebElement AssignedToOption;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

   public WebElement getIndustryDropDown() {
		return industryDropDown;
	}


	public WebElement getAssignedToOption() {
		return AssignedToOption;
		
	}
	
		public WebElement getSaveBtn() {
			return SaveBtn;
		}
	
		
		public void CreateNewOrg( String ORGNAME)
		{
			OrgNameEdt.sendKeys(ORGNAME);
			SaveBtn.click();
		}
		
		
	public void CreateNewOrg( String ORGNAME, String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown1(industryDropDown,INDUSTRY);
		SaveBtn.click();
			}
}
