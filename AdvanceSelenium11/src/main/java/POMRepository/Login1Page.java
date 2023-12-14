package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Login1Page {

	public Login1Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement userTextField;
	
//@FindBys({@FindBy(xpath="//input[@type='password']"),@FindBy(name="user_password")})
//private WebElement passwordTextField;
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	
//@FindAll({@FindBy(xpath="//input[@type='submit']"),@FindBy(id="submitButton")})
//private WebElement loginButton;
@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="(//input[@value='Login'])[2]")})
private WebElement loginButton;

public WebElement getUserTextField() {
	return userTextField;
}

public WebElement getPasswordTextField() {
	return passwordTextField;
}

public WebElement getLoginButton() {
	return loginButton;
}


public void loginToApplication(String userNAme,String Password)
{
	userTextField.sendKeys(userNAme);
	passwordTextField.sendKeys(Password);
	loginButton.click();
}






}
