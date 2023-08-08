package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
@Test

	public void sampleTest() 
	{
		int a=1;//exp
		int b=2;//act
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals(a,b);
		System.out.println("Step 3");
		System.out.println("Step 4");
		System.out.println("Execution and Validation is complete");
	}

@Test

 public void SampleTest1()
 {
	 SoftAssert sa= new SoftAssert();
	    int a=1;      //exp
		int b=2;      //act
	    System.out.println("Step 1");
		System.out.println("Step 2");
	    System.out.println("Step 3");
		Assert.assertEquals(a,b);
		sa.assertEquals(false, true);
		System.out.println("Step 4");
		sa.assertTrue(true);
		System.out.println("Execution and Validation is complete");
	    sa.assertAll();//logging all the failures
 }
}
