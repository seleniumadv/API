package excel.utility;


import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	String testDataPath = "./testData/TestData.xlsx";

	public String getDataFromExcel(String sheetName , int rowNum , int cellNum) throws Exception {
	
		FileInputStream fis = new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
		
	}
	
	public String getDataFromExcel1(String sheetName , int rowNum , int cellNum) throws Exception {
		
		FileInputStream fis = new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
		
	}
	
	
	
	public int getRowCount1(String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}
	
	public int getRowCount(String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}
	public void setDataIntoExcel(String sheetName , int rowNum , int cellNum , String data) throws Exception {
		FileInputStream fis = new FileInputStream(testDataPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(testDataPath);
		wb.write(fos);
		wb.close();
	}
}
