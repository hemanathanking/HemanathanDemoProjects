package Pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StandardObjects.AbstractComponents;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

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
	List<WebElement> ProductTitle;
	@FindBy(xpath="//div[@class='inventory_item_price']")
	List<WebElement> ProductPrice;
	@FindBy(xpath = "//button[text()='Add to cart']")
	List<WebElement> AddToCart;
	@FindBy(className = "product_sort_container")
	WebElement Sort;
	@FindBy(xpath = "//select[@class='product_sort_container']//option")
	List<WebElement> SortOptions;
	


	public void Sorting(String SortMethod)
	{
		SelectByVisibleText(Sort, SortMethod);
		
		String SeletedMethod=SelectedOption(Sort);
		
		if(SeletedMethod.contains("Price (low to high)"))
		{
			for(int i=0;i<ProductPrice.size();i++)
			{
				String Prices=ProductPrice.get(i).getText();
				System.out.println(Prices);
		}
		}
		else if(SeletedMethod.contains("Price (high to low)"))
		{
			for(int i=0;i<ProductPrice.size();i++)
			{
				String Prices=ProductPrice.get(i).getText();
				System.out.println(Prices);
		}
		}
		else if(SeletedMethod.contains("Name (A to Z)"))
		{
			for(int i=0;i<ProductTitle.size();i++)
			{
				String Titles=ProductTitle.get(i).getText();
				System.out.println(Titles);		
			}
		}
		else if(SeletedMethod.contains("Name (Z to A)"))
		{
			for(int i=0;i<ProductTitle.size();i++)
			{
				String Titles=ProductTitle.get(i).getText();
				System.out.println(Titles);			
			}
		}
	}
	
	public CheckoutPage AddToCart(String ProductName)
	{
		for(int i=0;i<=ProductTitle.size();i++)
		{
			String Titles=ProductTitle.get(i).getText();
			if(Titles.contains(ProductName))
			{
				AddToCart.get(i).click();
				break;
			}
		}
		
		return new CheckoutPage(driver);
	}
}