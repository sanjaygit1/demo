package POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class ProductValidationPage {

	public ProductValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@value='Delete'])[1]")
	private WebElement deletePrd;
	
	//Business Logics
	public void checkPrdName(WebDriver driver,String ProductName)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+ProductName+"']"
				+ "/../preceding-sibling::td/input")).click();
	}
	public void deletePrdClick(WebDriver driver,WebDriver_Utility wlib)
	{
		deletePrd.click();
		wlib.Alertaccept(driver);
	}
}
