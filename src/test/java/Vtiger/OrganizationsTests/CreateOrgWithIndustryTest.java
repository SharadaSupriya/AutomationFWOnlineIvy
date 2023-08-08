package Vtiger.OrganizationsTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ObjectRepository.CreateNewOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrgInfoPage;
import ObjectRepository.OrgPage;
import vtiger.GenericUtilities.BaseClass;
@Test

public class CreateOrgWithIndustryTest extends BaseClass{

	@Test
	public void createOrgWithIndustryTest() throws Throwable {
		{
			/* JavaUtility jUtil=new JavaUtility();
			 ExcelFileUtility eUtil = new ExcelFileUtility();
			 PropertyFileUtility pUtil = new PropertyFileUtility();
			 WebDriverUtility wUtil = new WebDriverUtility();
			 WebDriver driver=null;
		
			*/ 
			// Read data from property File - Common Data 
			 
			/*	String BROWSER = pUtil.getDataFromPropertyFile("browser");
				String URL = pUtil.getDataFromPropertyFile("url");
				String UN = pUtil.getDataFromPropertyFile("username");
				String PWD = pUtil.getDataFromPropertyFile("password");
		
			//Reading TestData
			FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fise);
			Sheet sh = wb.getSheet("Organizations");
		*/
			
			String ORGNAME =eUtil.getDataFromExcel("Organizations", 4, 2)+jUtil.getRandomNumber();
			String INDUSTRY =eUtil.getDataFromExcel("Organizations", 4, 3);
            
			//Launching Browser
		/*	if(BROWSER.equalsIgnoreCase("Chrome"))
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
			
			//Login to Application
			//driver.findElement(By.name("user_name")).sendKeys(UN);
		    //driver.findElement(By.name("user_password")).sendKeys(PWD);
			//driver.findElement(By.id("submitButton")).click();
			
			LoginPage lp=new LoginPage(driver);
			lp.getUserNameEdt().sendKeys(UN);
			lp.getPasswordEdt().sendKeys(PWD);
			lp.getLoginBtn().click();
			
		*/
			//click on organizations link
			HomePage hp = new	HomePage(driver);
		    hp.getOrganizationslink().click();
		   
		    //click on create organization look up
		    OrgPage op = new OrgPage(driver);
		    op.getCreateOrgLookUpIcon().click();
		   
		    //create organization
		    CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
		    cnop.getOrgNameEdt().sendKeys(ORGNAME);
		    cnop.getIndustryDropDown().click();
		    cnop.getSaveBtn().click();
		    
		    //validate
		    OrgInfoPage oip = new OrgInfoPage(driver);
		    oip.getOrgHeaderText();
		    
		    String OrgHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
			 if(OrgHeader.contains(ORGNAME))
			{
				System.out.println("PASS");
				System.out.println(OrgHeader);
		     }
			 else
			 {
				  System.out.println("FAIL");
			 }
			
		
			//Logout of application
			//hp.SignOutOfApp(driver);
			//System.out.println("SignOut Successful");
			 
			 /*
			 WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(AdminImg).perform();
				driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
			  System.out.println("Logout Successful");
			  */
	}}
	@Test
	public void sample()
	{
		System.out.println("Sample method running!");
	}
}
