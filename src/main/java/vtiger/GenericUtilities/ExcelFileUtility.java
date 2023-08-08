package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/*
 * This class consists of generic methods related to excel
 * 
 */

public class ExcelFileUtility {
	
public String getDataFromExcel(String sheetName,int rowNo,int cellNo) throws Throwable,IOException
{
	 FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
     Workbook wb=WorkbookFactory.create(fis);
     String value=wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
     wb.close();
     return value;
     
}    
     public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo,String data) throws Throwable,IOException
     {
    	 FileInputStream fis=new FileInputStream(IConstants.excelfilePath);
    	 Workbook wb = WorkbookFactory.create(fis);
    	 Sheet sh=wb.createSheet(sheetName);
    	 Row r=sh.createRow(rowNo);
    	 Cell c=r.createCell(cellNo);
    	 c.setCellValue(data);
    	 
    	 FileOutputStream fos=new FileOutputStream(IConstants.excelfilePath);
    	 wb.write(fos);
    	 wb.close();
     }

/**
 * this method will read all the data inside a sheet to use in dataprovider
 * @param sheetName
 * @return 
 * @throws FileNotFoundException 
 * @throws EncryptedDocumentExeption
 * @throws IOException
 */
     
public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException,IOException
{
	FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
	Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh=wb.getSheet(sheetName);
	 int lastrow=sh.getLastRowNum();//capture no of rows
	 int lastcell=sh.getRow(0).getLastCellNum();//capture no of cells
	 Object[][] data= new Object[lastrow][lastcell];
	 for (int i=0;i<lastrow;i++)//for row navigation
	 {
		 for(int j=0;j<lastcell;j++)//for cell navigation
		 {
			 data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		 }
	 }
	 return data;
}

}

