package Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StandardObjects.AbstractComponents;
public class MarketSearch extends AbstractComponents
{
	WebDriver driver;
	public MarketSearch(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#search-input")
	WebElement CatSearch;
	By waiting=By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front search-autocomplete']//li");
	@FindBy(xpath="//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front search-autocomplete']//li")
	List<WebElement> SearchLists;
	By Exit=By.xpath("//a[.='Exit']");
	@FindBy(css=".exit")
	WebElement Popup;
	
	
	public AddCart search(String catname)  
	{
		Type(CatSearch,catname);	
		waitForElementsToAppear(waiting);
		for(int i=0;i<SearchLists.size();i++)
        {
            
         if(SearchLists.get(i).getText().contains(catname))
            {
                SearchLists.get(i).getText();
                SearchLists.get(i).click();
                break;
            }
        }
		waitForElementsToAppear(Exit);
		ClickOn(Popup);
		return new AddCart(driver);
	}
}
