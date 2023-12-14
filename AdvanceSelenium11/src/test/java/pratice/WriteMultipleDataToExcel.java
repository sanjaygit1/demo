package pratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteMultipleDataToExcel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/ExcelData10to12.xlsx");
		//FileInputStream fis=new FileInputStream("C:\\Users\\Shobha\\Desktop\\ExcelData10to12.xlsx");
		//Step2:-open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step:-3 get the control to the sheet
		Sheet sh = book.getSheet("Sheet1");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
                       //400
		for(int i=0;i<allLinks.size();i++)
		{
			Row row = sh.createRow(i);
			Cell cel = row.createCell(0);
			cel.setCellValue(allLinks.get(i).getAttribute("href"));
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/ExcelData10to12.xlsx");
		book.write(fos);
		book.close();
		}

}
