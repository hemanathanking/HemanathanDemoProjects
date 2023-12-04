package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StandardObjects.AbstractComponents;

public class Payment_method_new extends AbstractComponents
{
	public WebDriver driver;

	public Payment_method_new(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//li[@data-pm=\"non_challan_gpa\"]")
	WebElement PayMethod;
	@FindBy(css = "#non_challan_gpa_ddo_select")
	WebElement PAO;
	@FindBy(css = "#pi_details_designation_admin_approval")
	WebElement DesAdm;
	@FindBy(css = "#pi_details_designation_finance_approval")
	WebElement DesFin;
	@FindBy(css = "#pi_details_gst_invoice_owner_buyer")
	WebElement GST;
	@FindBy(xpath = "//button[contains(text(),'Block')]")
	WebElement Block;
	@FindBy(css = ".accepted")
	WebElement BlockYes;
	By BlockSuccess=By.cssSelector(".payment-blocked");
	@FindBy(css = ".payment-blocked")
	WebElement Blocked;
	@FindBy(css = "#fraud_information_verification_documents_attachment")
	WebElement FinApproval;
	@FindBy(css = ".form_continue")
	WebElement PaymentContinue;
	
	//ContractAndOtp
	@FindBy(css="#contract-iframe")
	WebElement iframe;
	@FindBy(css="#save")
	WebElement Save; 
	@FindBy(css = ".verify_button")
	WebElement ClickOTP;
	By OtpText=By.xpath("//div[contains(text(),'OTP has been successfully')]");
	@FindBy(css = ".otp")
	WebElement EnterOTP;
	@FindBy(xpath = "//input[@value='Verify OTP']")
	WebElement VerifyOTP; 
	
	Select PaymentAuthority=new Select(PAO);
	public  void Payment(String AdminDesignation,String ApprovalDesignation, String Filepath)
	{
		PayMethod.click();
		DesAdm.sendKeys(AdminDesignation);
		DesFin.sendKeys(ApprovalDesignation);
		GST.click();
		PaymentAuthority.selectByIndex(0);
		Block.click();
		BlockYes.click();
		waitForElementsToAppear(BlockSuccess);
		Blocked.click();
		FinApproval.sendKeys(Filepath);
		PaymentContinue.click();
	}
	
	public void ContractAndOtp(String OTP)
	{
		driver.switchTo().frame(iframe);
		ScrollAndClick(Save);
		SwitchToDefaultContent(driver);
		ScrollAndClick(ClickOTP);
		EnterOTP.sendKeys(OTP);
		WaitUntilElementClickable(VerifyOTP);
		VerifyOTP.click();
		
	}

}
