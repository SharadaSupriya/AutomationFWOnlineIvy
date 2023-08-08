package WeekendPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VtigerDebugEx3 {
 public static void Credentials(WebDriver driver)
 {
	 driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	}

}
