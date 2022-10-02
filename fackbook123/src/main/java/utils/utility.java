package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utility {
	private static FileInputStream  file ;
	private static WebDriver driver ;
	
	
	
//	public utility (WebDriver driver) {
//		this.driver = driver ;
//	}
//	public static void getScreenshot() throws IOException	{
//		
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss");
//		LocalDateTime now = LocalDateTime.now();
//		
//	// screenshot
//	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	File test = new File("E:\\Velocity may 21 eve B\\Automation\\test"+dtf.format(now)+".PNG");
//	FileHandler.copy(src, test);
//	}
	
	public static String fetchexceldata(String sheet1,int row,int cell) throws IOException  {
		String path = "C:\\Users\\Win\\Desktop\\Interview Que in mock no 3.xlsx";
		  file= new FileInputStream(path);
		String data;
		Workbook wb =WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet("sheet1");
		Row rw = sheet.getRow(0);
		Cell cl = rw.getCell(0);
		try {
			
			data = cl.getStringCellValue();
			}
			catch (IllegalStateException e) 
		{
			double d = cl.getNumericCellValue();
			
			data = Double.toString(d);
		
		}
		System.out.println(data+ " ");	
		return data ;
}

}