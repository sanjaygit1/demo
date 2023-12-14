package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POMRepository.CreateCampaignsPage;
import POMRepository.CreateProductPage;
import POMRepository.Home1Page;
import POMRepository.Login1Page;

import POMRepository.ProductWindowPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateCampaignWithProduct extends BaseClass {

	@Test(groups = "regressionTest")
//	public static void main(String[] args) throws Throwable {x
	public void createCampaignWithProduct() throws Throwable
	{
		//WebDriverManager.chromedriver().setup();
       // WebDriver driver=new ChromeDriver();
         File_Utility flib=new File_Utility();
         Java_Utility jlib=new Java_Utility();
         Excel_Utility elib=new Excel_Utility();
         WebDriver_Utility wlib=new WebDriver_Utility();
         
       /* wlib.maximizeScreen(driver);
		wlib.implicitwait(driver);
	    String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
		driver.get(URL);
		Login1Page login=new Login1Page(driver);
		login.loginToApplication(USERNAME, PASSWORD);*/
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		Home1Page home=new Home1Page(driver);
		home.productLink();
		//driver.findElement(By.linkText("Products")).click();
        
		CreateProductPage product=new CreateProductPage(driver);
		product.clickProductImg();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
        
        int ranNum = jlib.getRandomNum();
        String ProductName = elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
        
        product.productName(ProductName);
	   // driver.findElement(By.name("productname")).sendKeys(ProductName);
	    Thread.sleep(2000);
	    product.clickSaveButton();
	  // driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
	
	    home.clickMoreLink(driver);
	 // driver.findElement(By.linkText("More")).click();
	  // driver.findElement(By.linkText("Campaigns")).click();
	    
	    CreateCampaignsPage campaigns=new CreateCampaignsPage(driver);
	    campaigns.clickCampPlusimg();
	// driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	    
	    
	    ProductWindowPage prdWindow=new ProductWindowPage(driver);
	    prdWindow.clickOnSelectSign(driver, wlib);
	  // driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
    	//wlib.switchWindow(driver,"Products&action");

	Thread.sleep(1000);
	prdWindow.productName(ProductName);
	//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ProductName);
	prdWindow.searchPrdData();
	//driver.findElement(By.xpath("//input[@name='search']")).click();
	
	//    "+value+"
	//driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	prdWindow.selectProduct(driver, ProductName, wlib);
	//driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	
	//wlib.switchWindow(driver, "Campaigns&action");

	String CampaginName = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
	
	campaigns.campaignsName(CampaginName);
  // driver.findElement(By.name("campaignname")).sendKeys(CampaginName);
   
	campaigns.clickSaveButton();
  // driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
	
   Thread.sleep(2000);
   home.logout(driver);
	 //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	   // driver.findElement(By.linkText("Sign Out")).click();
	}

}
