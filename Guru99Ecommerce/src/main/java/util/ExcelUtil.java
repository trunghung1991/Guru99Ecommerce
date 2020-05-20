package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	ArrayList<ExcelData> list = new ArrayList<>();
	String path;

	public static void ReadExcel(String path) {
//		this.path = path;

		try {
			FileInputStream file = new FileInputStream(new File(path));
			HashMap<Integer, ExcelData> mp = new HashMap<Integer, ExcelData>();
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			System.out.println("Opened excel");

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					int i = 0;
					int j = 0;
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						if (j == 0) {
							ExcelData data = mp.get(i);
							data.setInvoiceDate(cell.getStringCellValue());
							mp.put(i, data);
							j = j + 1;
						} else {
							ExcelData data = mp.get(i);
							data.setInvoiceDate(cell.getStringCellValue());
							mp.put(i, data);
							j = 0;
						}
						break;
					default:
						break;
					}
				}
				System.out.println("");
			}
			List<ExcelData> dataList = new ArrayList<ExcelData>();
			for (ExcelData data : mp.values()) {
				dataList.add(data);
			}
//			workbook.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}