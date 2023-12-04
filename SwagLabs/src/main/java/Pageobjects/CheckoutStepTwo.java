package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StandardObjects.AbstractComponents;

public class CheckoutStepTwo extends AbstractComponents
{
	WebDriver driver;
	public CheckoutStepTwo(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//button[@id='finish']")
	WebElement Finish;
	@FindBy(xpath="//button[@id='cancel']")
	WebElement Cancel;
	
	public CheckoutComplete CompleteOrder()
	{
		ClickOn(Finish);
		return new CheckoutComplete(driver);
	}
	
	public void CancelOrder()
	{
		ClickOn(Cancel);
	}
}
