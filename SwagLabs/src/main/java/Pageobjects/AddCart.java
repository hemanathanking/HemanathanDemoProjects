package Pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StandardObjects.AbstractComponents;

public class AddCart extends AbstractComponents
{
WebDriver driver;

	public  AddCart(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='inventory_item_name ']")
	List<WebElement> ProductTile;
	@FindBy(xpath="//div[@class='inventory_item_price']")
	List<WebElement> ProductPrice;
	@FindBy(xpath = "//button[text()='Add to cart']")
	List<WebElement> AddToCart;
	@FindBy(className = "product_sort_container")
	WebElement Sort;
	@FindBy(xpath = "//select[@class='product_sort_container']//option")
	List<WebElement> SortOptions;
	
	
	public CheckoutPage AddToCart(String ProductName)
	{
		for(int i=0;i<=ProductTile.size();i++)
		{
			String Titles=ProductTile.get(i).getText();
			if(Titles.contains(ProductName))
			{
				AddToCart.get(i).click();
				break;
			}
		}
		
		return new CheckoutPage(driver);
	}
	
	public void Sort(String SortMethod)
	{
		for(WebElement sortvalue: SortOptions)
		{
			
			if(sortvalue.getText().equalsIgnoreCase(SortMethod))
			{
				SelectByVisibleText(Sort, SortMethod);
				for(int i=0;i<ProductTile.size();i++)
				{
					String Titles=ProductTile.get(i).getText();
					
					ArrayList Dsc=new ArrayList();
					Dsc.add(Titles);
					System.out.println(Dsc);
				}
			}
			else if(sortvalue.getText().equalsIgnoreCase(SortMethod))
			{
				SelectByVisibleText(Sort, SortMethod);
				for(int i=0;i<ProductTile.size();i++)
				{
					String Titles=ProductTile.get(i).getText();
					
					ArrayList Asc=new ArrayList();
					Asc.add(Titles);
					System.out.println(Asc);
				}
			}
			else if(sortvalue.getText().equalsIgnoreCase(SortMethod))
			{
				SelectByVisibleText(Sort, SortMethod);
				for(int i=0;i<ProductPrice.size();i++)
				{
					String Prices=ProductPrice.get(i).getText();
					
					ArrayList LowToHigh=new ArrayList();
					LowToHigh.add(Prices);
					System.out.println(Prices);
			}
			}
			else if(sortvalue.getText().equalsIgnoreCase(SortMethod))
			{
				SelectByVisibleText(Sort, SortMethod);
				for(int i=0;i<ProductPrice.size();i++)
				{
					String Prices=ProductPrice.get(i).getText();
					
					ArrayList HighToLow=new ArrayList();
					HighToLow.add(Prices);
					System.out.println(HighToLow);
					
			}
		}  
	}
	
}}