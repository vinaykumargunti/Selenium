package dataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfigure {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;

	public ExcelDataConfigure(String path) {

		File src = new File(path);
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String getData(int sheetnumber, int rownum1, int cellnum1) {
		sheet = wb.getSheetAt(sheetnumber);
		String data = sheet.getRow(rownum1).getCell(cellnum1).getStringCellValue();
		System.out.println(data);
		return data;
	}
	
	public int rowcount(int sheetnumber) {
		sheet = wb.getSheetAt(sheetnumber);
	int rowcount = sheet.getLastRowNum();
	System.out.println(rowcount);
	return rowcount+1;
	
	}
}
