package com.banking.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Admin
 * This class is used for excel activities
 */
public class ExcelUtility {
	/**
	 * This method is used to read data from excel
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readExcelData(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
{
	FileInputStream fl=new FileInputStream(IPConstants.excelPath);
	Workbook workbook = WorkbookFactory.create(fl); 
	Sheet sh=workbook.getSheet(sheetName);
	Row row = sh.getRow(rowNo);
	Cell cell = row.getCell(cellNo);
	String data=cell.toString();
	return data;
}
/**
 * This method is used to write data inside excel sheet
 * @param sheetName
 * @param rowNo
 * @param cellNo
 * @param value
 * @throws EncryptedDocumentException
 * @throws FileNotFoundException
 * @throws IOException
 */
public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo,String value) throws EncryptedDocumentException, FileNotFoundException, IOException
{
	Workbook workbook = WorkbookFactory.create(new FileInputStream(IPConstants.excelPath));
	Sheet sh=workbook.getSheet(sheetName);
	Row row = sh.createRow(rowNo);
	Cell cell = row.createCell(cellNo);
	cell.setCellValue(value);
	FileOutputStream fout=new  FileOutputStream(IPConstants.excelPath);
	workbook.write(fout);
	workbook.close();
}
/**
 * This method will fetch count of rows created in excel sheet
 * @param sheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws FileNotFoundException
 * @throws IOException
 */
public int getRowCount(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException
{
	Workbook workbook=WorkbookFactory.create(new FileInputStream(IPConstants.excelPath));
	Sheet sh=workbook.getSheet(sheetName);
	int row=sh.getLastRowNum();
	return row;
}
/**
 * This method is used to fetch data from excel in the form of key & value by using map concept
 * @param sheetName
 * @param keyColumn
 * @param valueColumn
 * @param driver
 * @param jLib
 * @return
 * @throws Throwable
 */
//public HashMap<String,String> getMultipleDataFromExcel(String sheetName,int keyColumn,int valueColumn,WebDriver driver,JavaUtility jLib) throws Throwable
public HashMap<String,String> getMultipleDataFromExcel(String sheetName,int keyColumn,int valueColumn) throws Throwable
{
FileInputStream fl=new FileInputStream(IPConstants.excelPath);
Workbook wb=WorkbookFactory.create(fl);
Sheet sh = wb.getSheet(sheetName);
int rowcount = sh.getLastRowNum();

HashMap<String,String> map=new HashMap<String,String>();//empty map
for(int i=1;i<=rowcount;i++)//here you should specify the row value, from where you are starting i.e. i value
{
	String key = sh.getRow(i).getCell(keyColumn).getStringCellValue();
	String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
	map.put(key, value);
}

return map;
}
/**
 * This method is used to read multiple set of data from excel when we are using data provider
 * @param sheetName
 * @return
 * @throws Throwable
 */
public Object[][] getMultipleSetOfData(String sheetName) throws Throwable
{
	Workbook wb = WorkbookFactory.create(new FileInputStream(IPConstants.excelPath));
	Sheet sh = wb.getSheet(sheetName);
	int lastrow = sh.getLastRowNum();
	int lastcell = sh.getRow(0).getLastCellNum();
	
	Object[][] obj = new Object[lastrow+1][lastcell];
	for(int i=0;i<=lastrow;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}
}