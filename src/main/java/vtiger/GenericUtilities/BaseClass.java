package vtiger.GenericUtilities;
/**
 * this class consists of all the basic configuration annotation for 
 * all the common actions
 * @author shara
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public JavaUtility jUtil=new JavaUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	
	public WebDriver driver=null;
	
	//only used for listener to take screenshot
	public static WebDriver sdriver;
	
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("**** db connection successful*****");
	}
	
	
	//@Parameters("browser")//hold a value
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws Throwable 
	{
		//read browser name and URL from propertyFile
	   String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   System.out.println(BROWSER+"------Browser Launched");
		   
		}
		
		else if(BROWSER.equalsIgnoreCase("Edge"))
		   {
			WebDriverManager.edgedriver().setup();
			   driver=new EdgeDriver();
			   System.out.println(BROWSER+"----------Browser Launched---------");
		   }
		else
		{
			System.out.println("Invalid Browser");	
		}
		
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		sdriver=driver;
		
		//Loading URL
		   driver.get(URL);
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws Throwable
	{
		//read username and password from property file
		
		String UN = pUtil.getDataFromPropertyFile("username");
		String PWD = pUtil.getDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(UN, PWD);
		System.out.println("===Login Successful===");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.SignOutOfApp(driver);
		System.out.println("===LogOut Successful===");
		}
	
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("----------Browser Closed------------");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("*******db connection closed****** ");
	}
}
