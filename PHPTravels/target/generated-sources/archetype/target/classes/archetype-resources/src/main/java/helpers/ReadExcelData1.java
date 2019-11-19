#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.helpers;

import java.io.FileInputStream;



import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ${package}.constants.ConstantPaths;

public class ReadExcelData1 {
	public static String[][] getUserData(String filePath) throws IOException {
		FileInputStream fileInput = new FileInputStream(filePath);
		XSSFWorkbook book = new XSSFWorkbook(fileInput);
		org.apache.poi.ss.usermodel.Sheet sheet = book.getSheetAt(0);
		int row1 = sheet.getLastRowNum();
		row1 += 1;
		int col = sheet.getRow(0).getLastCellNum();
		String array[][] = new String[row1][col];
		int count = 0;
		for (Row row : sheet) {
			int count1 = 0;
			for (Cell cell : row) {
				String Data = cell.toString();
				array[count][count1] = Data;
				count1++;
			}
			count++;

		}
		book.close();
		return array;

	}

	@DataProvider(name = "data")
	public String[][] GetData() throws IOException {
		return ReadExcelData1
				.getUserData(ConstantPaths.PHP_FILE);
		
	}

	/*
	 * @Test(dataProvider = "data",dataProviderClass=ReadExcelData1.class) public
	 * void Input(String[] in) { System.out.println(in[0]); }
	 */
}
