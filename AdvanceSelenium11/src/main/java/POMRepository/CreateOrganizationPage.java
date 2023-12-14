package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

public CreateOrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement CreateOrganizationImg;

@FindBy(name="accountname")
private WebElement OrganizationName;

@FindBy(id="phone")
private WebElement OrganizationPhoneNum;

@FindBy(id="email1")
private WebElement OrganizationEmailId;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveButton;
//getter methods
public WebElement getCreateOrganizationImg() {
	return CreateOrganizationImg;
}

public WebElement getOrganizationName() {
	return OrganizationName;
}

public WebElement getOrganizationPhoneNum() {
	return OrganizationPhoneNum;
}

public WebElement getOrganizationEmailId() {
	return OrganizationEmailId;
}

public WebElement getSaveButton() {
	return saveButton;
}

//Business Logics

public void clickOrgPlus()
{
	CreateOrganizationImg.click();
}

public void OrganizationData(String orgName,String phoneNum,String emailId)
{
	OrganizationName.sendKeys(orgName);
	OrganizationPhoneNum.sendKeys(phoneNum);
	OrganizationEmailId.sendKeys(emailId);
}
public void clickSaveButton()
{
	saveButton.click();	
}





}


