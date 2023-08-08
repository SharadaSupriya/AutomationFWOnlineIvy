package Vtiger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {


public static void main(String[] args) throws EncryptedDocumentException, IOException  {
	FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	//create sheet
	Sheet sh = wb.createSheet("Trial");
	//create row
	Row rw=sh.createRow(4);
	//create cell
	Cell ce = rw.createCell(3);
	//set the value into cell
   ce.setCellValue("Spider Man");
	//open the file in java write format
  FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
  //call the write method
   wb.write(fos);
	System.out.println("Data added");
	//close the workbook
	wb.close();
	System.out.println("Workbook closed");
	
	
	
	
	
	
	
	
	
	
	







}
	
	
	
	
	
	
	
	
	
}
