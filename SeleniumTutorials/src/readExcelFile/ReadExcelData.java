package readExcelFile;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	static XSSFSheet sheet;
	public static void readExcelSheetDatageneral(String path, int sheetnumber) throws IOException {
	

		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(sheetnumber);
		int rowcount = sheet.getLastRowNum();
     	System.out.println(rowcount);

	}
	
	public static void getData(int rownum1,int cellnum1) {
		
		Object data=sheet.getRow(rownum1).getCell(cellnum1).getStringCellValue();
		System.out.println(data);
	}

}
