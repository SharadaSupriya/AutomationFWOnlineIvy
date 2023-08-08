package Vtiger.OrganizationsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.CreateNewOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgInfoPage;
import ObjectRepository.OrgPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateMultipleOrgWithIndustry extends BaseClass{
	 /*JavaUtility jUtil=new JavaUtility();
	 ExcelFileUtility eUtil = new ExcelFileUtility();
	 PropertyFileUtility pUtil = new PropertyFileUtility();
	 WebDriverUtility wUtil = new WebDriverUtility();
	*/
	
	@Test(dataProvider="getData")
	 public void createMultipleOrg(String ORG,String INDUSTRY) throws Throwable
	 {
		/*WebDriver driver=null;
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String UN = pUtil.getDataFromPropertyFile("username");
		String PWD = pUtil.getDataFromPropertyFile("password");
		*/
		
		String ORGNAME = ORG+jUtil.getRandomNumber();
	
		
		// Step 2: Launch the browser - driver is acting based runtime data - RunTime
	      // polymorphism
/*		
	      if (BROWSER.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        System.out.println(BROWSER + " --- Browser launched");

	      } else if (BROWSER.equalsIgnoreCase("firefox")) {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	        System.out.println(BROWSER + " --- Browser launched");
	      } else {
	        System.out.println("invalid Browser name");
	      }

	      wUtil.maximizeWindow(driver);
	      wUtil.waitForElementsToLoad(driver);

	      // Step 3: Load the URL
	     driver.get(URL);
*/
	      // Step 4: Login to the Application
	   //   LoginPage lp = new LoginPage(driver);
	     // lp.loginToApp(UN, PWD);

	      // Step 5: Click on Organizations Link
	      HomePage hp = new HomePage(driver);
	      hp.ClickOnOrgLink();

	      // Step 6: click on Create Organization look up image
	      OrgPage op = new OrgPage(driver);
	      op.ClickonCreateOrgLookUpIcon();

	      // Step 6: create Organization
	      CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
	      cnop.CreateNewOrg(ORGNAME, INDUSTRY);

	      // Step 8: Validate
	      OrgInfoPage oip = new OrgInfoPage(driver);
	      String OrgHeader = oip.getHeaderText();
	      if (OrgHeader.contains(ORGNAME)) {
	        System.out.println("PASS");
	        System.out.println(OrgHeader);
	      } else {
	        System.out.println("Fail");
	      }

	      // Step 9: Logout of Application
	   //   hp.SignOutOfApp(driver);
	    
	    }

	    @DataProvider
	    public Object[][] getData() throws Throwable, IOException {
	      return eUtil.readMultipleData("multipleOrg");
	    }
}
		
		
		
		
		
		
		
		
		
		
		
		
	