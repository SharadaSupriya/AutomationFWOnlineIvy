package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider="phones")
	// @Test(dataProvider= "getData")
	public void addToCartTest(String name,int price,String model)
   {
	  System.out.println("phone name is "+name+" price is "+price+"  model is "+model);
	   
   }
	
	
	 @DataProvider(name="phones")
    //@DataProvider
	 public Object[][] getData()
	 {
		 Object[][] data=new Object[3][3];
		 
		 data[0][0]="iphone";
		 data[0][1]=20000;
		 data[0][2]="s12";
		 
		 data[1][0]="samsung";
		 data[1][1]=15000;
		 data[1][2]="a80";
		 
		 data[2][0]="vivo";
		 data[2][1]=10000;
		 data[2][2]="y21";
		 return data;
		 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
}
