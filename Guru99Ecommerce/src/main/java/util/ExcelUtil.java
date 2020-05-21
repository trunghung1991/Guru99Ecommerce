package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

//	String path;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap ReadExcel(String path) {
		// Used the LinkedHashMap and LikedList to maintain the order
		HashMap<String, LinkedHashMap<Integer, List>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List>>();

		LinkedHashMap<Integer, List> hashMap = new LinkedHashMap<Integer, List>();

		String sheetName = null;
		// Create an ArrayList to store the data read from excel sheet.
		// List sheetData = new ArrayList();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			// Create an excel workbook from the file system
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			// Get the first sheet on the workbook.
			for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
				XSSFSheet sheet = workBook.getSheetAt(i);
				// XSSFSheet sheet = workBook.getSheetAt(0);
				sheetName = workBook.getSheetName(i);

				Iterator rows = sheet.rowIterator();
				while (rows.hasNext()) {
					XSSFRow row = (XSSFRow) rows.next();
					Iterator cells = row.cellIterator();

					List data = new LinkedList();
					while (cells.hasNext()) {
						XSSFCell cell = (XSSFCell) cells.next();
						cell.setCellType(CellType.STRING);
						data.add(cell);
					}
					hashMap.put(row.getRowNum(), data);

					// sheetData.add(data);
				}
				outerMap.put(sheetName, hashMap);
				hashMap = new LinkedHashMap<Integer, List>();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		List data1 = new ArrayList();
		for(List data2 : hashMap.values() ) {
			System.out.println(data1.add(data2));
		}

		return outerMap;

	}
//		List<String> invoiceDateList = new ArrayList<String>();
//		HashMap<Integer, Data> mp = new HashMap<Integer, Data>();
//		InputStream XlsxFileToRead = null;
//		XSSFWorkbook workbook = null;
//		try {
//			XlsxFileToRead = new FileInputStream(path);
//
//			// Getting the workbook instance for xlsx file
//			workbook = new XSSFWorkbook(XlsxFileToRead);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		// getting the first sheet from the workbook using sheet name.
//		// We can also pass the index of the sheet which starts from '0'.
//		XSSFSheet sheet = workbook.getSheet("Sheet1");
//		XSSFRow row;
//		XSSFCell cell;
//
//		// Iterating all the rows in the sheet
//		Iterator<Row> rows = sheet.rowIterator();
//
//		while (rows.hasNext()) {
//			row = (XSSFRow) rows.next();
//			if (row.getRowNum() != 0) {
//
//				// Iterating all the cells of the current row
//				Iterator<Cell> cells = row.cellIterator();
//
//				while (cells.hasNext()) {
//					cell = (XSSFCell) cells.next();
////					int i = 0;
////					int j = 0;
//
//					switch (cell.getCellType()) {
//					case STRING:
//						System.out.print(cell.getStringCellValue() + "\t");
////                        if( j==0){
////						Data d = mp.get(i);
////						d.setInvoiceDate(cell.getStringCellValue());
////						mp.put(i, d);
////						i = i + 1;
////                        j=j+1;
////                        }
////                        else
////                        {
////                            Data d= mp.get(i);
////                            d.setInvoiceDate(cell.getStringCellValue());
////                            mp.put(i, d);
////                            j=0;
////                        }
//						invoiceDateList.add(cell.getStringCellValue());
//						break;
////						
//					case NUMERIC:
//						DataFormatter dataFormat = new DataFormatter();
//						invoiceDateList.add(dataFormat.formatCellValue(cell));
//						System.out.println(dataFormat.formatCellValue(cell) + "\t");
//						break;
//					default:
//						break;
//					}
//				}
//
////				List<ExcelData> dataList = new ArrayList<ExcelData>();
////				for (ExcelData data : mp.values()) {
////					System.out.println(dataList.add(data));
////				System.out.println();
//				try {
//					XlsxFileToRead.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		for (String list1 : invoiceDateList) {
//			System.out.println(list1);
//		}
//		for (Double d : id) {
//			System.out.println(d);
//		}
}
