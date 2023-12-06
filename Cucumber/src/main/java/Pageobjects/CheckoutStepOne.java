package Pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StandardObjects.AbstractComponents;
public class CheckoutStepOne extends AbstractComponents
{
	WebDriver driver;
	public CheckoutStepOne(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='first-name']")
	WebElement FirstName;
	@FindBy(xpath="//input[@id='last-name']")
	WebElement LastName;
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement PostalCode;
	@FindBy(xpath="//button[@id='cancel']")
	WebElement Cancel;
	@FindBy(xpath="//input[@id='continue']")
	WebElement Continue;
	
	public void UserDetails(String First, String Last, String Pincode)
	{
		//driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(First);
		Type(FirstName, First);
		Type(LastName, Last);
		Type(PostalCode, Pincode);
	}
	
	public void Cancel()
	{
		ClickOn(Cancel);
	}
	
	public CheckoutStepTwo Continue()
	{
		ClickOn(Continue);
		return new CheckoutStepTwo(driver);
	}
}
