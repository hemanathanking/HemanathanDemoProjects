package Framework;	

import org.testng.annotations.Test;
import Pageobjects.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;


import com.aventstack.extentreports.ExtentReports;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import Pageobjects.AddCart;
import Pageobjects.CheckoutPage;
import Pageobjects.Login;
import Pageobjects.CheckoutStepOne;
import StandardObjects.BaseTest;

public class SauceTest extends BaseTest
{
	@Test(dataProvider="data")
	public void Validation(HashMap<String, String> input) throws IOException
	{
		Login Obj=LaunchBrowser();
		Obj.LaunchApp();
		Obj.Login1(input.get("username"), input.get("password"));
		AddCart cart=Obj.TitleValidation();
		
		cart.Sort(input.get("SortValue"));
		
		//Assert.assertEquals(Title, input.get("Expected Title"));
		
//		CheckoutPage checkout=cart.AddToCart(input.get("ProductName"));
//		
//		CheckoutStepOne checkoutstepone=checkout.ProceedTocheckout();
//		checkoutstepone.UserDetails(input.get("FirstName"), input.get("LastName"),input.get("PostalCode"));
//		
//		CheckoutStepTwo checkoutsteptwo=checkoutstepone.Continue();
//		CheckoutComplete complete=checkoutsteptwo.CompleteOrder();
//		
//		System.out.println(complete.OrderConfirmation());
//		
//		Menu menu=complete.GoBackToHome();
//		
//		menu.ClickOnMenu();
//		menu.Logout();
		
		
	}
	
	
}
