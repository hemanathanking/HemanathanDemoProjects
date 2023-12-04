package Pageobjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StandardObjects.AbstractComponents;
import StandardObjects.BaseTest;

public class CheckoutPage extends AbstractComponents
{

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".shopping_cart_link")
	WebElement Cart;
	@FindBy(xpath="//div[@class='inventory_item_name ']")
	List<WebElement> ProductTile;
	@FindBy(xpath = "//button[.='Remove']")
	List<WebElement> Remove;
	@FindBy(xpath="//button[@id='continue-shopping']")
	WebElement Continueshopping;
	@FindBy(xpath="//button[@id='checkout']")
	WebElement Checkout;
	
	
	public void RemoveItemFromCart(String itemname)
	{
		for(int i=0;i<=ProductTile.size();i++)
		{
			String titles=ProductTile.get(i).getText();
			if(titles.contains(itemname))
			{
				Remove.get(i).click();
			}
		}
	}
	
	public void ContinueShopping()
	{
		ClickOn(Continueshopping);
	}
	
	public CheckoutStepOne ProceedTocheckout()
	{
		ClickOn(Cart);
		ClickOn(Checkout);
		return new CheckoutStepOne(driver);
	}
	
	
}
