package Vtiger;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VTigerApplication {
public static void main(String[] args) throws Throwable {
	Random r = new Random();
	int random=r.nextInt(1000);
	//Launch browser
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
    driver.manage().window().maximize();
    
    //Navigate to URL
    driver.get("http://localhost:8888/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//Login to application
	driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
/*	//CONTACTS  SCENARIO====1
   driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Kapoor");
   Thread.sleep(1000);
   driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath("//input[@value=\"  Save  \"][1]")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath("//td[@onmouseover=\"fnDropDownUser(this,'ondemand_sub','~abc@gmail.com`');\"]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
   
 //ORGANIZATION  SCENARIO===2
   	driver.findElement(By.xpath("//a[text()=\"Organizations\"][1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys("SAMRUDDHI");
	Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@value=\"  Save  \"][1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()=\"Organizations\"][1]")).click();
	Thread.sleep(1000);
	 driver.findElement(By.xpath("//td[@onmouseover=\"fnDropDownUser(this,'ondemand_sub','~abc@gmail.com`');\"]")).click();
	 Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
	*/
	   
	//ORGANIZATION  SCENARIO===3
	//create Organization
	driver.findElement(By.xpath("//a[text()=\"Organizations\"][1]")).click();
	driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	String OrgName = "BEML"+random;
	driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(OrgName);
	driver.findElement(By.xpath("//select[@name=\"industry\"]")).click();
	driver.findElement(By.xpath("//option[@value=\"Education\"]")).click();
    driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
	driver.findElement(By.xpath("//input[@value=\"  Save  \"][1]")).click();
   
	 
	 //Validate
	 String OrgHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	 if(OrgHeader.contains(OrgName))
	{
		System.out.println("PASS");
		System.out.println(OrgHeader);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	
	 //ORGANIZATION SCENARIO====4 and SCENARIO====5
	driver.findElement(By.xpath("//a[text()=\"Organizations\"][1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys("SAMRUDDHI");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//select[@name=\"industry\"]")).click();
	  Thread.sleep(3000);
	 driver.findElement(By.xpath("//option[@value=\"Energy\"]")).click();
	 Thread.sleep(1000); 
	 driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@value=\"  Save  \"][1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[text()=\"Organizations\"][1]")).click();
	Thread.sleep(1000);
    driver.findElement(By.xpath("//td[@onmouseover=\"fnDropDownUser(this,'ondemand_sub','~abc@gmail.com`');\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
	*/
}
	
	
}
