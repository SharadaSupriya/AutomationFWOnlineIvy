package Practice;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Auto {
		public static void main(String[] args) throws Throwable {
			WebDriver driver=new ChromeDriver();
			WebDriverManager.chromedriver().setup();
		    driver.manage().window().maximize();
		/*	driver.get("https://www.flipkart.com/");
			driver.findElement(By.cssSelector("[class=\"_2KpZ6l _2doB4z\"]")).click();
		    driver.findElement(By.name("q")).sendKeys("nike");
			Thread.sleep(1000);
			
			List<WebElement> Allsuggestion=driver.findElements(By.tagName("li"));
			for(WebElement wb:Allsuggestion)
			{
				
				if(wb.getText().contains("shoes"));
				{
					Thread.sleep(1000);
					wb.click();
					break;
				}
			}
			*/
		    
	//amazon
		    driver.get("https://www.amazon.in/");
		  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("puma");
		  Thread.sleep(2000);
		  List<WebElement> allsuggestion = driver.findElements(By.xpath("//div[@class='left-pane-results-container']/div//span"));
	                                                                     
		  	for(WebElement wb:allsuggestion)
		  	{
		  		String text = wb.getText();
		  		System.out.println(text);
		  		if(text.equalsIgnoreCase("flip flops for men"))
		  		{
		  			wb.click();
		  			break;
		  		}
		  	}
		  	}	
			}

