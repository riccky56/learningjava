package utilities;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility2 {

	/**
	 * ONE method that handles everything:
	 *  - null / blank path            -> IllegalArgumentException
	 *  - file missing / not a file    -> IOException with full path
	 *  - null / blank / unknown sheet -> ""
	 *  - negative row or column       -> ""
	 *  - null row (never created)     -> ""
	 *  - null cell (never created)    -> ""
	 *  - empty / blank cell           -> ""
	 *  - number, date, boolean        -> shown exactly as in Excel (12345, not 12345.0)
	 *  - formula                      -> evaluated; falls back to last saved value
	 *  - error cell (#N/A, #REF!)     -> shown as text, never throws
	 *  - garbage (NBSP, zero-width, BOM, control chars, extra spaces) -> cleaned and trimmed
	 *
	 * Row and column are 0-based. Never returns null.
	 */
	public static String getCellData(String path, String sheetName, int rownum, int colnum) throws IOException {

		if (path == null || path.trim().isEmpty()) {
			throw new IllegalArgumentException("Excel file path must not be null or empty");
		}
		File file = new File(path.trim());
		if (!file.exists() || !file.isFile()) {
			throw new IOException("Excel file not found: " + file.getAbsolutePath());
		}
		if (sheetName == null || sheetName.trim().isEmpty() || rownum < 0 || colnum < 0) {
			return "";
		}

		try (FileInputStream fi = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fi)) {

			// sheet lookup: exact, then case-insensitive / trimmed
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
					if (workbook.getSheetName(i).trim().equalsIgnoreCase(sheetName.trim())) {
						sheet = workbook.getSheetAt(i);
						break;
					}
				}
			}
			if (sheet == null) {
				return "";
			}

			Row row = sheet.getRow(rownum);
			if (row == null) {
				return "";
			}

			Cell cell = row.getCell(colnum);
			if (cell == null) {
				return "";
			}

			DataFormatter formatter = new DataFormatter();
			String data;
			try {
				FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
				data = formatter.formatCellValue(cell, evaluator);
			} catch (Exception formulaProblem) {
				try {
					data = formatter.formatCellValue(cell); // cached value fallback
				} catch (Exception e) {
					return "";
				}
			}

			if (data == null) {
				return "";
			}
			// remove NBSP, zero-width chars, BOM, line/paragraph separators, control chars
			return data.replaceAll("[\\u00A0\\u200B\\u200C\\u200D\\u2028\\u2029\\uFEFF\\p{Cntrl}]", " ").trim();
		}
	}
}
