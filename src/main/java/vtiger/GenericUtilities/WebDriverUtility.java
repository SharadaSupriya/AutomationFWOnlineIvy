package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/*
 *This class consists of all the re usable methods related to webdriver actions
 *@author Sharada 
 *
 */
public class WebDriverUtility {
	
public void maximizeWindow(WebDriver driver)
/*
 * This method will maximize the window
 * @param driver
 */
  {driver.manage().window().maximize();}


/*
* This method will minimize the window
* @param driver
*/
public void minimizeWindow(WebDriver driver)
{driver.manage().window().minimize();}


public void waitForElementsToLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	
public void waitForElementsToBeVisible(WebDriver driver,WebElement element)
{
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(element));
}
/*
 * This method will handle drop down using index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element,int index) {
	Select sel = new Select(element);
	sel.selectByIndex(index);
}

/*
 * This method will handle drop down using value
 * @param element
 * @param value
 */
public void handleDropDown1(WebElement ORGNAME,String value) {
	Select sel = new Select(ORGNAME);
	sel.selectByValue(value);
}
/*
 * This method will handle drop down using visibleText
 * @param text
 * @param element
 */
public void handleDropDown(String text,WebElement element) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
}

/*
 * This method will double click anywhere on the web page
 * @param driver
 */

	public void mouseHoverAction(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}

public void doubleClickAction(WebDriver driver )
{
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}

/*
 * This method will double click on a web element
 * @param driver
 * @param element
 * /
 * 
 */
public void doubleClickAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
/*
 * This method will perform right click anywhere on the web page	
 * @param driver
 */
  public void rightCickAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
		}
  /*
   * This method will perform right click on particular web element	
   * @param driver
   *@param element
   */
	public void rightCickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		}
	/*
	 * This method will perform drag and drop action
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 * 
	 */
	public void dragAnddropAction(WebDriver driver,WebElement srcEle,WebElement targetEle)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcEle,targetEle).perform();
	}
	
	/*
	 * This method is used to move the cursor anywhere on the webpage based on offsets
	 * @param driver
	 * @param xoffset
	 * @param Offset
	 * 
	 */
	
	public void moveAcrossWebPage(WebDriver driver,int xOffset,int yOffset)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(xOffset, yOffset).perform();
	}
	
	/*
	 * Thos method will scroll vertically for 500 pixels
	 * @param driver
	 * 
	 */
	 public void scrollAction(WebDriver driver)
	 {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.ScrollBy(0,500);","");
	}
	 /*
		 * Thos method will scroll vertically until the element reference
		 * @param driver
		 * @?param element
		 */
	 
	 public void scrollAction(WebDriver driver,WebElement element)
	 {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 int y=element.getLocation().getY();
		 js.executeScript("window.ScrollBy(0,"+y+");",element);
		 //js.executeScript("arguments[0].scrollIntoView();",element);
		 
	 }
	 /*
		  *This method will accept the alert pop up
		  *@param driver
		  * 
		  */
	 public void acceptAlert(WebDriver driver)
		 {
			 driver.switchTo().alert().accept();
		 }
	 
	 /*
	  *This method will cancel the confirmation pop up
	  *@param driver
	  * 
	  */
 public void cancelAlert(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();
	 }
 
 /*
  *This method will enter the text in prompt pop up
  *@param driver
  */
  public void sendTextToAlert(WebDriver driver,String text)
  {
	  driver.switchTo().alert().sendKeys(text);
  }
  /*
   *This method will capture the alert message and return to the caller
   *@param driver
   *@return
   */
  public String getAlertText(WebDriver driver)
  {
	  return driver.switchTo().alert().getText();
 }
  /*
   * 
   * 
   */
 public void handleFrame(WebDriver driver,int index)
 {
	 driver.switchTo().frame(index);
 }
 /*
  * 
  * 
  */
 public void handleFrame(WebDriver driver,String nameOrID)
 {
	 driver.switchTo().frame(nameOrID);
 }
 public void handleFrame(WebDriver driver,WebElement element)
 {
	 driver.switchTo().frame(element);
 } 
 public void switchToParentFrame(WebDriver driver)
 {
	 driver.switchTo().parentFrame();
	 }
 public void switchToDefaultPage(WebDriver driver)
 {
	 driver.switchTo().defaultContent();}



/**
 * This method will switch 
 * @param driver 
 * @param partialWinTitle 
 * 
 * 
 */
public void switchToWindow(WebDriver driver,String partialWinTitle)
  {
	//Step 1: capture all the window IDs
	 Set<String> allWindowIds=driver.getWindowHandles();
	//Step 2: iterate through individual IDs
	 for(String winID:allWindowIds)
	 {    
		 //Step 3: switch to each ID and capture the title
		 String currentTitle=driver.switchTo().window(winID).getTitle();
		
		 //step 4:Compare the title with required reference
		 if(currentTitle.contains(partialWinTitle))
				 {break;
				 }
	 }
  }
/*
 * this method will take screen shot and return the absolute path of it
 * @param driver
 * @param screenshotName
 * @return path
 * @throws IOException
 */
public String takeScreenshot(WebDriver driver, String screenshotName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst=new File(".\\ScreenShots\\"+screenshotName+".png");
	Files.copy(src, dst);//this class is from commons IO tool
	return dst.getAbsolutePath();
}

}

 