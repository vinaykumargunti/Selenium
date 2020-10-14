package readExcelFile;

import java.io.IOException;

public class ExcelSheetData {
	public static void main(String[] args) throws IOException {
		
		ReadExcelData.readExcelSheetDatageneral("D:\\Coding\\Skills.xlsx", 0);
		
		ReadExcelData.getData(3,1);
		
		
	}

}
