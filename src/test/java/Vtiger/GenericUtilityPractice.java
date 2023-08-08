package Vtiger;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args)throws Throwable {
		
		JavaUtility jUtil=new JavaUtility();
		
		int value=jUtil.getRandomNumber();
		System.out.println(value);
		
		System.out.println(jUtil.getSystemDate());
	    System.out.println(jUtil.getSystemDateInFormat());
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value1 = pUtil.getDataFromPropertyFile("browser");
		System.out.println(value1);
		
	ExcelFileUtility eUtil=new ExcelFileUtility();
	 String data = eUtil.getDataFromExcel("Organizations",4,2);
	 System.out.println(data);
	    
	    eUtil.writeDataIntoExcel("San",2,1,"Hello");
	   System.out.println("Data added");
	
	}

}
