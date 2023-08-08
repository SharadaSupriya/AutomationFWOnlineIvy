package Vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	public static void main(String[] args) throws Throwable  {
		
		//1.Load the file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//2.create a workbook for the file loaded
	Workbook book=WorkbookFactory.create(fis);
	 //3.navigate to required sheet
      Sheet sh = book.getSheet("Contacts");
//4.navigate to required row
      Row row = sh.getRow(1);
      //5.navigate to required cell
      Cell cell= row.getCell(2);
      //6.Capture the value inside the cell
     String value = cell.getStringCellValue();
     System.out.println(value);
         }

	
	
	
	
	
}
