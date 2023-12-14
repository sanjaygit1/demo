package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMRepository.CreateProductPage;
import POMRepository.Home1Page;
import POMRepository.Login1Page;

import POMRepository.ProductValidationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndDeleteProduct1 extends BaseClass{

	@Test
	public void createProductAndDeleteProduct1() throws Throwable {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		WebDriver_Utility wlib=new WebDriver_Utility();
//		driver.manage().window().maximize();
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		File_Utility flib=new File_Utility();
//		String URL = flib.getKeyAndValue("url");
//		String USERNAME = flib.getKeyAndValue("username");
//		String PASSWORD = flib.getKeyAndValue("password");
//	/*	FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData.properties");
//		Properties pro = new Properties();
//		pro.load(fis);
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");*/
//		
//		driver.get(URL);
//		Login1Page login=new Login1Page(driver);
//		login.loginToApplication(USERNAME, PASSWORD);
//		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		//driver.findElement(By.id("submitButton")).click();
		
		Home1Page home=new Home1Page(driver);
		home.productLink();
		//driver.findElement(By.linkText("Products")).click();
		CreateProductPage product=new CreateProductPage(driver);
		product.clickProductImg();
	   //driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRandomNum();
		//Random ran = new Random();
	     //int ranNum = ran.nextInt(1000);
		
	     Excel_Utility elib = new Excel_Utility();
	     String ProductName=elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
	     
//		FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet sheet = book.getSheet("Product");
//		Row row = sheet.getRow(0);
//	     Cell cell = row.getCell(0);
//	    String ProductName = cell.getStringCellValue()+ranNum;
	    
	    product.productName(ProductName);
	   // driver.findElement(By.name("productname")).sendKeys(ProductName);
	    Thread.sleep(2000);
	    product.clickSaveButton();
	  //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();

	home.productLink();
	   // driver.findElement(By.linkText("Products")).click();
	
	ProductValidationPage deletePrd=new ProductValidationPage(driver);
	deletePrd.checkPrdName(driver, ProductName);
	
	//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+ProductName+"']"
	//		+ "/../preceding-sibling::td/input")).click();
	deletePrd.deletePrdClick(driver, wlib);
	//driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
	
	//WebDriver_Utility wlib=new WebDriver_Utility();
	//wlib.Alertaccept(driver);
	//Alert alt = driver.switchTo().alert();
	//alt.accept();
	
	 Thread.sleep(2000);
	 List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));

	 boolean flag=false;
	 
	 for(WebElement prdName:productList)
	 {
		String actData = prdName.getText();
		if(actData.contains(ProductName))//nikeshoes512.contains(nikeshoes100)
		{
			flag=true;
			break;
		}
	 }
	if(flag)
	{
		System.out.println("product data is deleted");
	}
	else
	{
		System.out.println("product data not deleted");
	}
	home.logout(driver);
//	 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//	    driver.findElement(By.linkText("Sign Out")).click();
	}

}
