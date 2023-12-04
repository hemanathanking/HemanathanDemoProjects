package Framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import Pageobjects.Login;
import StandardObjects.BaseTest;

public class Testing extends BaseTest
{
	@Test(dataProvider="data")
	public void Validation(HashMap<String, String> input) throws IOException
	{
		Login Obj=LaunchBrowser();
		Obj.LaunchApp();
		Obj.Login1(input.get("username"), input.get("password"));
		
		List<WebElement> Price=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
//		for(WebElement x: Price)
//		{
//			System.out.println(x.getText());
//		}
		
		for(int i=0;i<Price.size();i++)
		{
			String Prices=Price.get(i).getText();
			
			ArrayList LowToHigh=new ArrayList();
			LowToHigh.add(Prices);
			System.out.println(Prices);
	}
		
	}
}
