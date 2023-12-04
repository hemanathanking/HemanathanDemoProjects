package Pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StandardObjects.AbstractComponents;

public class AddCart extends AbstractComponents
{
	public WebDriver driver;

	public  AddCart(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//Adding consignee
	@FindBy(css="#administrative")
	WebElement Administrative;
	@FindBy(xpath = "//div[@class='edit-consignees button']")
	WebElement AddConsignee;
	@FindBy(xpath = "//select[@class='delivery-state']")
	WebElement ConsState;
	@FindBy(xpath ="//tr[@class='location-filters']//td[2]//select")
	WebElement ConsLoc;
	@FindBy(css = "#_consignee_data__required_quantity")
	WebElement Quantity;
	@FindBy(xpath = "//input[@value='Search']")
	WebElement Search;
	
	//Adding product to cart
	@FindBy(xpath = "(//input[@class='button add-to-cart-fake-action-button'])[1]")
	WebElement ADDTOCART;
	@FindBy(xpath = "//button[.='Direct Purchase']")
	WebElement DP;
	
	//comment
	
	@FindBy(css=".gem-2-proceed-to-checkout-button")
	WebElement DirectPurchase;
	@FindBy(xpath = "//button[.='Yes, rate reasonability has been certified by Competent Authority']")
	WebElement Yes;
	@FindBy(xpath="//button[.='Continue']")
	WebElement Continue;

	

	Select Loc=new Select(ConsLoc);
	public void Consignee(String State,String ConSigneeLocation,String Quan)
	{
		Administrative.click();
		ScrollAndClick(AddConsignee);
		SelectByVisibleText(ConsState,State);
		List<WebElement> LocList=Loc.getOptions();
		for (WebElement Loca : LocList) 
		{
			if(Loca.getText().contains(ConSigneeLocation))
			{
				ClickOn(Loca);
			}
		}
		Type(Quantity,Quan);
		ClickOn(Search);
	}
	
	public CheckoutPage DpCart()
	{
		ScrollAndClick(ADDTOCART);
		ClickOn(DP);
		ClickOn(DirectPurchase);
		ClickOn(Yes);
		ScrollAndClick(Continue);
		return new CheckoutPage(driver);
	}
	}