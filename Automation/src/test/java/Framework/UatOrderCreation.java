package Framework;	

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


import com.aventstack.extentreports.ExtentReports;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import Pageobjects.AddCart;
import Pageobjects.CheckoutPage;
import Pageobjects.LoginModule;
import Pageobjects.MarketSearch;
import StandardObjects.BaseTest;

public class UatOrderCreation extends BaseTest
{
	ExtentReports extent;
	@Test(dataProvider="data")
	public void OrderCreation(HashMap<String, String> input) throws IOException
	{
		LoginModule loginmodule=LaunchBrowser();
		loginmodule.LaunchApp(input.get("URL"));
		loginmodule.login(input.get("username"), input.get("captcha"), input.get("password"));
		MarketSearch CatSearch=loginmodule.Checkbox();
		AddCart cart=CatSearch.search(input.get("CatName"));
		cart.Consignee(input.get("State") ,input.get("Location"),input.get("Quantity"));
		CheckoutPage checkout=cart.DpCart();
		checkout.Payment(input.get("AdminDesignation"), input.get("FinanceDesignation"), input.get("FinApprovalDoc"));
		checkout.ContractAndOtp(input.get("OTP"));
	}
}
