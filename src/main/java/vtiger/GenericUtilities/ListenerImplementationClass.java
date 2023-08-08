package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 * Example for ABSTRACTION
 * @author shara
 *
 */
public class ListenerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println("----Execution started-----"+methodName);
		test =report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		//System.out.println("----PASS-----"+methodName);
		test.log(Status.PASS,"----PASS-----"+methodName);
	}

	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		//System.out.println("----FAIL-----"+methodName);
		test.log(Status.FAIL,"----FAIL-----"+methodName);
		//System.out.println(result.getThrowable());
		test.log(Status.INFO,"----INFO-----"+methodName);
		
		WebDriverUtility wu=new WebDriverUtility();
	   JavaUtility ju = new    JavaUtility();
	   
	   String screenshotName= methodName+ju.getSystemDateInFormat();
	   //take screenshot for failed test scripts --to attach with bug rising
	   
	   try {
		
		   String path = wu.takeScreenshot( BaseClass.sdriver, screenshotName);
	        test.addScreenCaptureFromPath(path);
	   } 
	   catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public void onTestSkipped(ITestResult result) 
	{
		         String methodName    = result.getMethod().getMethodName();
		//System.out.println("------SKIP-------"+methodName);
		         test.log(Status.SKIP,"----SKIP-----"+methodName);
		//System.out.println(result.getThrowable());
		         test.log(Status.INFO,"----INFO-----"+methodName);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	//start of <suite>-- @BeforeSuite
	{
		System.out.println("---Suite execution started-----");	
	
	//Configure the extent Report
    ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
	htmlreport.config().setDocumentTitle("Vtiger Execution Report");
	htmlreport.config().setReportName("Build 3 Vtiger Execution Report");
	htmlreport.config().setTheme(Theme.DARK);
	
	
	//Report Generation
	report=new ExtentReports();
	report.attachReporter(htmlreport);
	report.setSystemInfo("Base Browser","chrome");
	report.setSystemInfo("Base Platform","Testing-Env");
	report.setSystemInfo("Base URL","https://localhost:888");
	report.setSystemInfo("Base OS","Windows");
	report.setSystemInfo("Reporter","Sharada");
	
	
	}
	
	public void onFinish(ITestContext context )
	{	
		//end of <suite>-- @AfterSuite
		System.out.println("---Suite execution ended-----");
		//report generation
		report.flush();
	}

	}
