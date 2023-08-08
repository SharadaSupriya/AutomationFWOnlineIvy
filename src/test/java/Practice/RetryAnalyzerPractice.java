package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	
    @Test(retryAnalyzer =vtiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
    	Assert.fail();
		System.out.println("HI");
	}
	
}
