package Generic_Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POMRepository.Home1Page;
import POMRepository.Login1Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
public File_Utility flib=new File_Utility();
public WebDriver_Utility wLib=new WebDriver_Utility();
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("parallel execution");
	}
	@Parameters("BROWSER")
	@BeforeClass
	public void beforeClass(String BROWSER) throws Throwable
	{
	//	File_Utility flib=new File_Utility();
		//WebDriver driver;
	 //  String BROWSER = flib.getKeyAndValue("browser");
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
	   }
		System.out.println("Launching Browser");
		wLib.implicitwait(driver);
		String URL = flib.getKeyAndValue("url");
		driver.get(URL);
	}
	@BeforeMethod
	public void beforeMethod() throws Throwable
	{
		
		
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");

		
		//pom class implementing
		Login1Page login1=new Login1Page(driver);
	    //calling using Business Logics
		login1.loginToApplication(USERNAME, PASSWORD);
		System.out.println("login to Application");
	}
	@AfterMethod
	public void afterMethod()
	{
		 Home1Page home=new Home1Page(driver);
		home.logout(driver);
		System.out.println("logout from Application");
	}
	@AfterClass
	public void afterClass()
	{
		//driver.quit();
		System.out.println("Close Browser");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("parallel execution done");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Data BAse Connection Close");
	}
}
