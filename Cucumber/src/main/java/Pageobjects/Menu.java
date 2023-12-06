package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StandardObjects.AbstractComponents;

public class Menu extends AbstractComponents
{
	WebDriver driver;
	
	public Menu(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#react-burger-menu-btn")
	WebElement MenuButton;
	@FindBy(css="#inventory_sidebar_link")
	WebElement AllItems;
	@FindBy(css="#about_sidebar_link")
	WebElement About;
	@FindBy(css="#logout_sidebar_link")
	WebElement Logout;
	@FindBy(css="#reset_sidebar_link")
	WebElement Reset;
	
	public void ClickOnMenu()
	{
		ClickOn(MenuButton);
	}
	
	public void ViewAllItems()
	{
		WaitUntilElementClickable(AllItems);
		ClickOn(AllItems);
	}
	
	public void About()
	{
		WaitUntilElementClickable(About);
		ClickOn(About);
	}
	
	public void Logout()
	{
		WaitUntilElementClickable(Logout);
		ClickOn(Logout);
	}
	
	public void Reset()
	{
		WaitUntilElementClickable(Reset);
		ClickOn(Reset);
	}
}
