package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1:create a separate POM class for every Web page
//Rule 2: Identify the web elements using @FindBy ,@findAll
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id ="submitButton")
	private WebElement loginBtn;
	
//Rule 3: create a constructor to initialize the web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Rule 4:provide getters to access these web elements
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library-project specific generic method
	/*this method will perform login operation
	 * @param UN
	 * @param PWD
	 * 
	 */
	public void loginToApp(String UN,String PWD)
	{
		userNameEdt.sendKeys(UN);
		passwordEdt.sendKeys(PWD);
		loginBtn.click();
	}}
