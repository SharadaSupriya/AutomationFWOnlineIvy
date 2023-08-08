package Vtiger.OrganizationsTests;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

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

public class CreateOrgWithIndustry {

	public static void main(String[] args) throws Throwable {
		{
			 JavaUtility jUtil=new JavaUtility();
			 ExcelFileUtility eUtil = new ExcelFileUtility();
			 PropertyFileUtility pUtil = new PropertyFileUtility();
			 WebDriverUtility wUtil = new WebDriverUtility();
			 WebDriver driver=null;
		
			 
			// Read data from property File - Common Data 
			 
				String BROWSER = pUtil.getDataFromPropertyFile("browser");
				String URL = pUtil.getDataFromPropertyFile("url");
				String UN = pUtil.getDataFromPropertyFile("username");
				String PWD = pUtil.getDataFromPropertyFile("password");
		
			//Reading TestData
			FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fise);
			Sheet sh = wb.getSheet("Organizations");
			String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue()+jUtil.getRandomNumber();
			String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
            
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
			
			//Login to Application
			//driver.findElement(By.name("user_name")).sendKeys(UN);
		    //driver.findElement(By.name("user_password")).sendKeys(PWD);
			//driver.findElement(By.id("submitButton")).click();
			
			LoginPage lp=new LoginPage(driver);
			lp.getUserNameEdt().sendKeys(UN);
			lp.getPasswordEdt().sendKeys(PWD);
			lp.getLoginBtn().click();
			
			
			HomePage hp = new	HomePage(driver);
		    hp.getOrganizationslink().click();
		   
		    
		    OrgPage op = new OrgPage(driver);
		    op.getCreateOrgLookUpIcon().click();
		   
		    
		    CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
		    cnop.getOrgNameEdt().sendKeys(ORGNAME);
		    cnop.getIndustryDropDown().click();
		    cnop.getSaveBtn().click();
		    
		    OrgInfoPage oip = new OrgInfoPage(driver);
		    oip.getOrgHeaderText();
		    
		    
		    
			
			/*driver.findElement(By.xpath("//a[text()=\"Organizations\"][1]")).click();
			driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
			driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(ORGNAME);
			WebElement industryDropDown = driver.findElement(By.name("industry"));
			Select s = new Select(industryDropDown);
			s.selectByValue(INDUSTRY);
			driver.findElement(By.xpath("//select[@name=\"industry\"]")).sendKeys(INDUSTRY);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		  */
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
			hp.SignOutOfApp(driver);
			System.out.println("SignOut Successful");
			 
			 /*
			 WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(AdminImg).perform();
				driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
			  System.out.println("Logout Successful");
			  */
	}}
		}
		
		
