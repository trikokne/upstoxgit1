package library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class POM_DDF_TestNG_Utilityclass 
{
	//author=@Trimurti
	//getTD takes two argument like 1. rowindex 2. cellindex
	public static String getTD(int rowindex,int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\trimurti\\eclipse-workspace\\Upstox_2ndjulyB_batch\\testdata\\demo1.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet3");
		String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		return value;	
	}
	
	public static void capturescreenshot(WebDriver driver,int TestcaseID) throws IOException
	{
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest=new File("C:\\Users\\trimurti\\eclipse-workspace\\Upstox_2ndjulyB_batch\\screenshot\\TCID"+TestcaseID+".jpg");
		 FileHandler.copy(src, dest);	
	}
	public static String getproeprtiesfile(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\trimurti\\eclipse-workspace\\Upstox_2ndjulyB_batch\\maven.properties");
		Properties p=new Properties();
		p.load(file);
		 String value = p.getProperty(key);
		 return value;
	}
}
