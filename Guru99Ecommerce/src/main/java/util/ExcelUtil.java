package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static List<String> ReadExcel(String path) {

		List<String> invoiceDateList = new ArrayList<String>();
		InputStream XlsxFileToRead = null;
		XSSFWorkbook workbook = null;
		try {
			XlsxFileToRead = new FileInputStream(path);

			// Getting the workbook instance for xlsx file
			workbook = new XSSFWorkbook(XlsxFileToRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// getting the first sheet from the workbook using sheet name.
		// We can also pass the index of the sheet which starts from '0'.
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row;
		XSSFCell cell;

		// Iterating all the rows in the sheet
		Iterator<Row> rows = sheet.rowIterator();

		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			if (row.getRowNum() != 0) {

				// Iterating all the cells of the current row
				Iterator<Cell> cells = row.cellIterator();

				while (cells.hasNext()) {
					cell = (XSSFCell) cells.next();

					switch (cell.getCellType()) {
					case STRING:
						invoiceDateList.add(cell.getStringCellValue());
						break;
					default:
						break;
					}
				}

				try {
					XlsxFileToRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return invoiceDateList;
	}
}
