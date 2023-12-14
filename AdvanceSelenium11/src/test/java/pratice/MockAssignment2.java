package pratice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockAssignment2 {

	@Test
	public void m1() throws Throwable {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		 WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("samsung");
		search.submit();
	
	  List<WebElement> phoneName = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"
	  		+ "//div[@class='a-section a-spacing-small a-spacing-top-small']//h2"));
	 List<WebElement> price = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"
	 		+ "//span[@class='a-price-whole']"));
	
	for(int i=0;i<phoneName.size();i++)
	{
		Thread.sleep(2000);
		String text = price.get(i).getText();
		String phoneprice = text.replace(",", "");
		Integer actPrice = Integer.valueOf(phoneprice);
	
	if(actPrice>=10000)
	{
		System.out.println(phoneName.get(i).getText()+"="+price.get(i).getText());
	}
	}
	
	}

}
