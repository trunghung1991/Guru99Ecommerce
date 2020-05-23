package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FileUtil {

	// Check file is successfully downloaded
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}

	// Read exported csv file
	public static void readCSV(String filePath, String fileName) {
		File f = new File(filePath + fileName);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		File dir = new File(filePath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted
				dirContents[i].delete();
			}
		}
	}

	// Get current datetime then add 1 hour and append to pdf file
	public static String appendDateTimeToPDF() {
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.HOUR, -11);
//		calender.add(Calendar.SECOND, -1);
		Date date = calender.getTime();
		String pdfTime = new SimpleDateFormat("'invoice'yyyy'-'MM'-'dd'_'HH'-'mm'-'ss'.pdf'").format(date);

		return pdfTime;
	}
}
