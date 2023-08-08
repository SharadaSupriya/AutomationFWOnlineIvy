package WeekendPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerDebugEx {

	public static void main(String[] args) {
	    WebDriver driver; 
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		VtigerDebugEx2.maximizeWindow(driver);
		VtigerDebugEx3.Credentials(driver);

	}

}
