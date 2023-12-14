package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MockAssignment1 extends BaseClass{

	@Test
	public void m1() {
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().window().maximize();
		
		String team = "U.P. Yoddhas";
	String points = driver.findElement(By.xpath("//p[text()='"+team+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-play']")).getText();
		System.out.println(points);
String won = driver.findElement(By.xpath("//p[text()='"+team+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-won']")).getText();
	System.out.println(won);
	
	}

}
