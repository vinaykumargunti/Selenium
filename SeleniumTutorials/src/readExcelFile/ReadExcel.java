package readExcelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	
	public static void main(String[] args) throws IOException, InvalidFormatException {

		XSSFSheet sheet;
           
		File src = new File("D:\\Coding\\Skills.xlsx");
		FileInputStream fis = new FileInputStream(src);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();

		System.out.println(rowcount);

		for (int i = 0; i < rowcount; i++) {

			sheet = wb.getSheetAt(0);

			String data = sheet.getRow(i).getCell(0).getStringCellValue();

			System.out.println(data);

		}

	}
}
