package pages;

	
	import java.io.File;
import java.io.FileInputStream;
	import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Reusables {
		
		Properties prop;
		String propValue;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		String cell; 
		WebDriver driver;
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Reusables reuse = new Reusables();
			System.out.println(reuse.ReadProperties("URL"));
			System.out.println(reuse.excelRead(1,0));
			
		} 

		public String ReadProperties(String KeyProperty)
		{
			prop = new Properties();
			
			try {
				FileReader fs = new FileReader("./ObjectRepository/objRepo.properties");
				prop.load(fs);
				propValue = prop.getProperty(KeyProperty);
			} catch(Exception e) {
				e.printStackTrace();
			}
			return propValue;
		}
		
		public String excelRead(int row, int col)
		{
			try
			{
				FileInputStream fis = new FileInputStream("./TestData/TestExcelData.xlsx");
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
				cell = sheet.getRow(row).getCell(col).getStringCellValue();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return cell;	
		}
		
		public void getScreenshot(String filename, WebDriver driver)
		{
			TakesScreenshot tscreenshot = (TakesScreenshot) driver;
			File img = tscreenshot.getScreenshotAs(OutputType.FILE);
			try
			{
			File DestFile = new File("./Screenshots/" + filename +".png");
			FileUtils.copyFile(img,DestFile);
			} catch (IOException e)
			{
                e.printStackTrace();
			}
			
		} 
}
