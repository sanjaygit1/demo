package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
//initilization
	public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}	
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administrator;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;
	
	//gettermethod
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}
	
	public WebElement getAdministrator() {
		return Administrator;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getProductLink() {
		return ProductLink;
	}
	/**
	 * This method is used to click on OranizationLink
	 */
	public void clickOrganizationLink()
	{
		OrganizationLink.click();
	}
	public void clickProductLink()
	{
		ProductLink.click();
	}
	public void logout(WebDriver driver) {
//		WebDriver_Utility wlib=new WebDriver_Utility();
//		wlib.ActionsMoveToElement(driver, Administrator);
		Actions act = new Actions(driver);
		act.moveToElement(Administrator).perform();
		signout.click();
}
}