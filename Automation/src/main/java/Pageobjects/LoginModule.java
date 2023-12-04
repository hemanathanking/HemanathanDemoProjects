package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StandardObjects.AbstractComponents;

public class LoginModule extends AbstractComponents
{
	WebDriver driver;

	public LoginModule(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "loginid")
	WebElement UserName;
	@FindBy(id = "captcha_math")
	WebElement Captcha;
	@FindBy(xpath = "//button[.='Submit']")
	WebElement Submit;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(id="arxLoginSubmit")
	WebElement Login;
	@FindBy(xpath="//input[@id='bulk_payment_checkbox']")
	WebElement Checkbox;
	@FindBy(xpath="//button[@class='button pull-right']")
	WebElement CheckOK;

	public void LaunchApp()
	{
		driver.get("https://sso.gemorion.org/ARXSSO/oauth/doLogin");
	}
	
	public void login(String username, String captcha, String password) 
	{
		Type(UserName,username);
		Type(Captcha,captcha);
		ClickOn(Submit);
		Type(Password,password);
		ClickOn(Login);	
	}
	
	public MarketSearch Checkbox()
	{
		Checkbox.click();
		CheckOK.click();
		return new MarketSearch(driver);
		 
	}
	
	
	

}