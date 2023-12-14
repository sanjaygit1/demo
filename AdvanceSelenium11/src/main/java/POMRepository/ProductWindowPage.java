package POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class ProductWindowPage {

	public ProductWindowPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement selectPlusSign;

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement ProductTextBox;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement ProductSearchButton;
	
	//getter Methods
	public WebElement getSelectPlusSign() {
		return selectPlusSign;
	}
   
	public WebElement getProductTextBox() {
		return ProductTextBox;
	}
    
	public WebElement getProductSearchButton() {
		return ProductSearchButton;
	}

	//Business Logics
    public void clickOnSelectSign(WebDriver driver,WebDriver_Utility wlib)
	{
		selectPlusSign.click();
		wlib.switchWindow(driver,"Products&action");
	}
	
	public void productName(String PrdName)
	{
		ProductTextBox.sendKeys(PrdName);
	}
	
	public void searchPrdData()
	{
		ProductSearchButton.click();
	}
	public void selectProduct(WebDriver driver,String ProductName,WebDriver_Utility wlib)
	{
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
		wlib.switchWindow(driver, "Campaigns&action");
	}
}
