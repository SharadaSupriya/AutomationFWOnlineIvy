package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	@FindBy(xpath="//a[.=\"Organizations\"][1]")
	private WebElement Organizationslink;
	
	@FindBy(xpath="//a[text()=\"Contacts\"]")
	private WebElement ContactsLink; 

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminImg;
	
	@FindBy(xpath="//a[text()=\"Sign Out\"]")
	private WebElement Signoutlink;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getOrganizationslink() {
		return Organizationslink;
	}

	public WebElement getContactsLink() {
	return ContactsLink;
	}


	public WebElement getAdminImg() {
	return AdminImg;
	}

   public WebElement getSignoutlink() {
		return Signoutlink;
	}

	
	//Business Library-project specific generic method
	/*this method will perform viewing home page
	 * 
	 */
	
	/*
	 * This method will click on Organizations Link
	 */
	public void ClickOnOrgLink()
	{
		Organizationslink.click();
	}
	
	/*
	 * This method will click on Contacts Link
	 */
	public void ClickOnContactsLink()
	{
		ContactsLink.click();
	}
	
	public void SignOutOfApp(WebDriver driver) throws Throwable
	{
		
		mouseHoverAction(driver,AdminImg);
		Thread.sleep(1000);
		Signoutlink.click();
		 
	}
	}
