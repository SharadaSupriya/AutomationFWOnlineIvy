package Vtiger.ContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.CreateNewOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgInfoPage;
import ObjectRepository.OrgPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws Throwable {
		
	//Create object of required Utilities
				 JavaUtility jUtil=new JavaUtility();
				 ExcelFileUtility eUtil = new ExcelFileUtility();
				 PropertyFileUtility pUtil = new PropertyFileUtility();
				 WebDriverUtility wUtil = new WebDriverUtility();
				 WebDriver driver=null;
				 
				 //Step 1:Read all the necessary data
				 //Read data from property file-Common Data
				String BROWSER = pUtil.getDataFromPropertyFile("browser");
				String URL = pUtil.getDataFromPropertyFile("url");
				String UN = pUtil.getDataFromPropertyFile("username");
				String PWD = pUtil.getDataFromPropertyFile("password");
				
			     //Read data from Excel sheet-- TestData
			    String ORGNAME = eUtil.getDataFromExcel("Contacts", 4,3)+jUtil.getRandomNumber();
				String LASTNAME= eUtil.getDataFromExcel("Contacts", 4, 2);
				
			//Launching Browser
				if(BROWSER.equalsIgnoreCase("Chrome"))
				{
				   WebDriverManager.chromedriver().setup();
				   driver=new ChromeDriver();
				   System.out.println(BROWSER+"------Browser Launched");
				   
				}
				
				else if(BROWSER.equalsIgnoreCase("Firefox"))
				   {
					WebDriverManager.firefoxdriver().setup();
					   driver=new FirefoxDriver();
					   System.out.println(BROWSER+"------Browser Launched");
				   }
				else
				{
					System.out.println("Invalid Browser");	
				}
				
				wUtil.maximizeWindow(driver);
				wUtil.waitForElementsToLoad(driver);
				
				//Loading URL
				driver.get(URL);
				
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(UN, PWD);
				
				HomePage hp=new HomePage(driver);
				hp.ClickOnOrgLink();
			
				//click on create org look up image
				OrgPage op=new OrgPage(driver);
				op.ClickonCreateOrgLookUpIcon();
				
				//create Organization
				CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
				cnop.CreateNewOrg(ORGNAME);
				
		  //Validate for Organization
				OrgInfoPage oip=new OrgInfoPage(driver);
				String OrgHeader = oip.getHeaderText(); 
				if(OrgHeader.contains(ORGNAME))
				{
					System.out.println("Organization Created");
					System.out.println(OrgHeader);
			     }
				 else
				 {
					  System.out.println("FAIL");
				 }
				
				 
				//Creating Contact using Organization
			  hp.ClickOnContactsLink();
			
			  //navigate to create new contact look up image
			  ContactsPage cp=new ContactsPage(driver);
			  cp.ClickOnCreateContactLookUpIcon();
			  
			//create a contact with mandatory information
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createContact(driver, LASTNAME, ORGNAME);
				
				//validate for Contacts
		
				ContactInfoPage cip=new ContactInfoPage(driver);
				String ContactHeader =cip.getContactHeader();
				if(ContactHeader.contains(LASTNAME))
					{
						System.out.println("PASS");
						System.out.println(ContactHeader);
				     }
				else
					 {
						  System.out.println("FAIL");
					 }
		
			
				//Logout of application
				hp.SignOutOfApp(driver);
				System.out.println("SignOut Successful");
				
			}
}
