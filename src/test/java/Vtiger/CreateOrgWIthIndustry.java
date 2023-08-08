package Vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWIthIndustry {
	public static void main(String[] args) throws FileNotFoundException ,IOException {
		
		Random r = new Random();
		int random=r.nextInt(1000);
		WebDriver driver=null;
		//Reading  CommonData
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String UN = pObj.getProperty("username");
		String PWD = pObj.getProperty("password");
	/*	
		//Reading TestData
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Organizations");
		String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue()+random;
		String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
	*/	
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Loading URL
		driver.get(URL);
		
		//Login to Application
		driver.findElement(By.name("user_name")).sendKeys(UN);
	    driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		
		
	/*
	
	   //creating Organizations	
		driver.findElement(By.xpath("//a[text()=\"Organizations\"][1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(ORGNAME);
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropDown);
		s.selectByValue(INDUSTRY);
		//driver.findElement(By.xpath("//select[@name=\"industry\"]")).sendKeys(INDUSTRY);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	   
		 
		 //Validate
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
		*/
		//Creating Contacts
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Contacts");
		String LNAME = sh.getRow(4).getCell(2).getStringCellValue()+random;
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(LNAME);
		driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"  Save  \"][1]")).click();
		String ConHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(ConHeader.contains(LNAME))
			{
				System.out.println("PASS");
				System.out.println(ConHeader);
		     }
		else
			 {
				  System.out.println("FAIL");
			 }
				
		//Logout of application
		 WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(AdminImg).perform();
			driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		  System.out.println("Logout Successful");
}
}
