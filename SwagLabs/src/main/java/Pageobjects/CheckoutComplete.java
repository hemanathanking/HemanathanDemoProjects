package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StandardObjects.AbstractComponents;

public class CheckoutComplete extends AbstractComponents
{
    WebDriver driver;
	
    public CheckoutComplete(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css =".complete-header")
	WebElement ConfimrationMessage;
	@FindBy(xpath="//button[@id='back-to-products']")
	WebElement BackHome;

	
	public String OrderConfirmation()
	{
		return ConfimrationMessage.getText();
	}
	
	public Menu GoBackToHome()
	{
		ClickOn(BackHome);
		return new Menu(driver);
	}
}
