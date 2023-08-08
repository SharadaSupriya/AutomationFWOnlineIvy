package Vtiger.ContactsTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.CreateNewOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrgInfoPage;
import ObjectRepository.OrgPage;
import vtiger.GenericUtilities.BaseClass;
@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	@Test(groups="SmokeSuite")
	public void createContactWithOrganizationTest() throws Throwable
	{
		//Create object of required Utilities
					/* JavaUtility jUtil=new JavaUtility();
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
					*/
				     //Read data from Excel sheet-- TestData
				    String ORGNAME = eUtil.getDataFromExcel("Contacts", 4,3)+jUtil.getRandomNumber();
					String LASTNAME= eUtil.getDataFromExcel("Contacts", 4, 2);
					
				//Launching Browser
				/*	if(BROWSER.equalsIgnoreCase("Chrome"))
					{
					   WebDriverManager.chromedriver().setup();
					   driver=new ChromeDriver();
					   System.out.println(BROWSER+"------Browser Launched");
					   
					}
					
					else if(BROWSER.equalsIgnoreCase("Firefox"))
					   {
						WebDriverManager.edgedriver().setup();
						   driver=new EdgeDriver();
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
					System.out.println("==== Login Successful ====");
					*/
					HomePage hp=new HomePage(driver);
					hp.ClickOnOrgLink();
				Reporter.log("Org link clicked");
					//click on create org look up image
					OrgPage op=new OrgPage(driver);
					op.ClickonCreateOrgLookUpIcon();
				Reporter.log("create org look up image is clicked");	
					//create Organization
					CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
					cnop.CreateNewOrg(ORGNAME);
				Reporter.log("Organization created");	
					
			  //Validate for Organization
					OrgInfoPage oip=new OrgInfoPage(driver);
					
					String OrgHeader=oip.getHeaderText();
					Assert.assertTrue(OrgHeader.contains(ORGNAME));
					System.out.println(OrgHeader);
					/*String OrgHeader = oip.getHeaderText(); 
					if(OrgHeader.contains(ORGNAME))
					{
						System.out.println("Organization Created");
						System.out.println(OrgHeader);
				     }
					 else
					 {
						  System.out.println("FAIL");
					 }
					*/
					 
					//Creating Contact using Organization
				  hp.ClickOnContactsLink();
				  Reporter.log("Contacts link clicked");
				
				  //navigate to create new contact look up image
				 // Assert.fail();
				  ContactsPage cp=new ContactsPage(driver);
				  cp.ClickOnCreateContactLookUpIcon();
				  Reporter.log("create contact look up image is clicked");
				  
				//create a contact with mandatory information
					CreateNewContactPage cncp = new CreateNewContactPage(driver);
					cncp.createContact(driver, LASTNAME, ORGNAME);
					Reporter.log("Contacts created");
					
					//validate for Contacts
			
					ContactInfoPage cip=new ContactInfoPage(driver);
					String ContactHeader =cip.getContactHeader();
				Assert.assertTrue(ContactHeader.contains(LASTNAME));
				/*if(ContactHeader.contains(LASTNAME))
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
					*/
				}
	
	@Test
	public void demotest()
	{
	   // Assert.fail();
		System.out.println("Demo");
	}
	}
	
	
	
	
	
