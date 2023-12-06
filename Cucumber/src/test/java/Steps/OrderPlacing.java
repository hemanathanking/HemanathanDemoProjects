package Steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pageobjects.AddCart;
import Pageobjects.CheckoutComplete;
import Pageobjects.CheckoutPage;
import Pageobjects.CheckoutStepOne;
import Pageobjects.CheckoutStepTwo;
import Pageobjects.Login;
import StandardObjects.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderPlacing extends BaseTest

{
	private WebDriver driver;
	private Login login;
	private AddCart cart;
	private CheckoutPage checkout;
	private CheckoutStepOne checkoutstepone;
	private CheckoutStepTwo checkoutsteptwo;
	private CheckoutComplete complete;
	
	@Given("Launch the browser and navigate to the Application")
	public void Launch_the_browser() throws IOException
	{
		login=LaunchBrowser();
		login.LaunchApp();
	}
	
	@When ("^Login into Application using (.+) and (.+) and Validate Title$")
	public void LoginAndValidateTitle(String username,String password)
	{
		login.Login1(username, password);
		cart=login.TitleValidation();
	}
	
	@When("^Add the product to cart if product name contains (.+)$")
	public void AddtoCart(String ProductName)
	{
		checkout=cart.AddToCart(ProductName);
	}
	
	@When("Continue checkout process by clicking on the cart")
	public void ProceedToCheckout()
	{
		checkoutstepone=checkout.ProceedTocheckout();
	}
	
	@When("^Fill the user details like (.+) , (.+) and (.+)$")
	public void FillTheUserdeatils(String FirstName, String LastName, String PostalCode)
	{
		checkoutstepone.UserDetails(FirstName,LastName,PostalCode);
	}
	
	@When("continue the checkout process")
	public void ContinueWithOrderPlacing()
	{
		checkoutsteptwo=checkoutstepone.Continue();
	}
	
	@When("Confirm the Purchase")
	public void ConfirmPurchase()
	{
	    complete=checkoutsteptwo.CompleteOrder();
	}
	
	@Then("^Verify the (.+)$")
	public void VerifyconfirmationAndLogout(String ConfirmationMessage)
	{
		String ActualMessage=complete.OrderConfirmation();
		Assert.assertEquals(ActualMessage, ConfirmationMessage);
	}
}
