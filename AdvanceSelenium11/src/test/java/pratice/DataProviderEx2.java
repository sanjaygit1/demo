package pratice;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx2 {

	@Test(dataProvider = "getData")
	public void vTiger(String orgNAme,String phnNum,String email) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("accountname")).sendKeys(orgNAme);
	driver.findElement(By.id("phone")).sendKeys(phnNum);
	driver.findElement(By.id("email1")).sendKeys(email);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
	}
	@DataProvider
	public Object[][] getData()
	{
		Random ran = new Random();
		int ranNUm = ran.nextInt(1000);
		Object[][] objarr = new Object[3][3];
		
		objarr[0][0]="AAA"+ranNUm;
		objarr[0][1]="3154545454";
		objarr[0][2]="vdgv@gmail.com";
		
		objarr[1][0]="BBB"+ranNUm;
		objarr[1][1]="315445454";
		objarr[1][2]="vdgv@gmail.com";
		
		objarr[2][0]="CCC"+ranNUm;
		objarr[2][1]="3154545454";
		objarr[2][2]="vdgv@gmail.com";
		
		return objarr;
}
}