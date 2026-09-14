package assignments;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexcel2 {
	public static void main(String[] args) throws IOException {

		String filePath = System.getProperty("user.dir") + "\\testdata\\exceldatademo.xlsx";

		try (FileInputStream file = new FileInputStream(filePath);
				XSSFWorkbook workbook = new XSSFWorkbook(file)) {

			XSSFSheet sheet = workbook.getSheet("Sheet1");

			if (sheet == null) {
				System.out.println("Sheet1 was not found.");
				return;
			}

			int totalRows = sheet.getLastRowNum() + 1;
			int totalColumns = sheet.getRow(0).getLastCellNum();

			System.out.println("Total number of rows: " + totalRows);
			System.out.println("Total number of columns: " + totalColumns);

			for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {

				XSSFRow currentRow = sheet.getRow(rowIndex);

				if (currentRow == null) {
					continue;
				}

				for (int columnIndex = 0; columnIndex < totalColumns; columnIndex++) {

					XSSFCell cell = currentRow.getCell(columnIndex);
					
					if (cell != null) {
						System.out.print(cell.toString());
					}

					System.out.print("\t");
				}

				System.out.println();
			}
		}
	}
}