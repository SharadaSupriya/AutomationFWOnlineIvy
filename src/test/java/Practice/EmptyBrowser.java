package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EmptyBrowser {
	public static void main(String[] args) {
	    //Launch the application
		WebDriver driver;
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		//get()----->used for launching WebApplication
		driver.get("https://www.myntra.com/");
	
	   	
		//getTitle()---used to get title of the WebPage
	  String title=driver.getTitle();
	  System.out.println(title);
	  
	  
	  //getCurrentURl()-->used to get URL for the application
	  String url = driver.getCurrentUrl();
	  System.out.println(url);

	  
	  //getPageSource()--->to print source code of the web page
	  String data = driver.getPageSource();
	  System.out.println(data);
	  
	  
	  driver.close();//closes only focused tab
	  //driver.quit();//close the entire application
		
	}

}
