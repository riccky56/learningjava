package Testng;


	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.*;

	public class ExcelDataProvider {

	    @DataProvider(name = "excelData")
	    public Object[][] readExcelData() throws IOException {
	        FileInputStream file = new FileInputStream("src/test/resources/testdata.xlsx");
	        Workbook workbook = new XSSFWorkbook(file);
	        Sheet sheet = workbook.getSheet("LoginData");

	        int rowCount = sheet.getPhysicalNumberOfRows();
	        Object[][] data = new Object[rowCount - 1][sheet.getRow(0).getPhysicalNumberOfCells()];

	        for (int i = 1; i < rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
	                data[i - 1][j] = row.getCell(j).getStringCellValue();
	            }
	        }
	        workbook.close();
	        file.close();
	        return data;
	    }

	    @Test(dataProvider = "excelData")
	    public void testLoginFromExcel(String username, String password, String expectedResult) {
	        System.out.println("Login with: " + username);
	        // Selenium logic
	    }
	}

