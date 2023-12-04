package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StandardObjects.AbstractComponents;

public class Login extends AbstractComponents
{
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement Username;
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	@FindBy(id="login-button")
	WebElement Login;
	
	
	public void LaunchApp()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	public void Login1(String UN,String PW)
	{
	Type(Username,UN);
	Type(Password, PW);
	ClickOn(Login);
	
	//return new AddCart(driver);
	}
	
	public AddCart TitleValidation()
	{
		System.out.println(driver.getTitle());
		 
		 return new AddCart(driver);
	}
}