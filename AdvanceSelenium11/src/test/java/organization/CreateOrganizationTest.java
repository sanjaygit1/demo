package organization;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import POMRepository.CreateOrganizationPage;
import POMRepository.HomePage;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganizationTest()throws Throwable {
	/*	File_Utility flib=new File_Utility();
		WebDriver driver;
	   String BROWSER = flib.getKeyAndValue("browser");
	   if(BROWSER.equalsIgnoreCase("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
	   }
	   else if (BROWSER.equalsIgnoreCase("firefox"))
	   {
		WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	}
	   else if (BROWSER.equalsIgnoreCase("edge")) 
	   {
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
	}
	   else
	   {
		   driver=new ChromeDriver();
	   }*/

	   
	/*String URL = flib.getKeyAndValue("url");
	String USERNAME = flib.getKeyAndValue("username");
	String PASSWORD = flib.getKeyAndValue("password");
/*	FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	driver.get(URL);
	
	//pom class implementing
	Login1Page login1=new Login1Page(driver);*/
	
	//calling using getter methods
	/*login1.getUserTextField().sendKeys(USERNAME);
	login1.getPasswordTextField().sendKeys(PASSWORD);
	login1.getLoginButton().click();*/
	
	//calling using Business Logics
	//login1.loginToApplication(USERNAME, PASSWORD);
	
	//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 //driver.findElement(By.id("submitButton")).click();;
		
	HomePage home=new HomePage(driver);
	home.clickOrganizationLink();
	//driver.findElement(By.linkText("Organizations")).click();
	CreateOrganizationPage org=new CreateOrganizationPage(driver);
	org.clickOrgPlus();
	//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	Java_Utility jlib=new Java_Utility();
	int ranNum = jlib.getRandomNum();
	/*Random ran = new Random();
     int ranNum = ran.nextInt(1000);*/
	
//	FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
//	Workbook book = WorkbookFactory.create(fes);
//	Sheet sheet = book.getSheet("Organization");
//	Row row = sheet.getRow(0);
//     Cell cell = row.getCell(0);
//    String OrgName = cell.getStringCellValue()+ranNum;
	
	Excel_Utility elib=new Excel_Utility();
	
	//String OrgName = elib.getExcelData("Organization", 0, 0)+ranNum;
	String OrgName = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
	//driver.findElement(By.name("accountname")).sendKeys(OrgName);
    Thread.sleep(2000);
    
   String orgNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
  // driver.findElement(By.id("phone")).sendKeys(orgNum);
    
   String orgEmail = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
  // driver.findElement(By.id("email1")).sendKeys(orgEmail);
   
   org.OrganizationData(OrgName, orgNum, orgEmail);
   
//    FileInputStream fes2 = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
//	Workbook book2 = WorkbookFactory.create(fes2);
//    Sheet sheet2 = book2.getSheet("Organization");
   /* Row row2 = sheet.getRow(1);
    Cell cell2 = row2.getCell(0);
    DataFormatter format = new DataFormatter();
	String orgNum = format.formatCellValue(cell2);
	driver.findElement(By.id("phone")).sendKeys(orgNum);
    
	  Thread.sleep(2000);
//  FileInputStream fes1 = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
//	Workbook book1 = WorkbookFactory.create(fes1);
//    Sheet sheet1 = book1.getSheet("Organization");
    Row row1 = sheet.getRow(2);
    Cell cell1 = row1.getCell(0);
    String orgEmail = format.formatCellValue(cell1);
    driver.findElement(By.id("email1")).sendKeys(orgEmail);*/
	
   // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    org.getSaveButton().click();
 /*String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
 if(actData.contains(OrgName))
 {
	 System.out.println("pass");
 }
 else
	 
 {
	 System.out.println("fail");
 }*/
 
/*	WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(element).click().perform();
	driver.findElement(By.linkText("Sign Out")).click();*/
	Thread.sleep(2000);
 //home.logout(driver);
    //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    //driver.findElement(By.linkText("Sign Out")).click();
	}

}
