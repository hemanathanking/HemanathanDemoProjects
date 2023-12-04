package Pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import StandardObjects.AbstractComponents;

public class CheckoutPage extends AbstractComponents
{
	public WebDriver driver;

	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Payment method
	@FindBy(css = "#payment_authority_select")
	WebElement PAO;
	@FindBy(css = "#pi_details_designation_admin_approval")
	WebElement DesAdm;
	@FindBy(css = "#pi_details_designation_finance_approval")
	WebElement DesFin;
	@FindBy(css = "#pi_details_gst_invoice_owner_buyer")
	WebElement GST;
	@FindBy(css = "#pi_details_is_consignee_a_bill_processor_true")
	WebElement ConsBill;
	@FindBy(css = "#fraud_information_verification_documents_attachment")
	WebElement FinApproval;
	@FindBy(css = ".form_continue")
	WebElement PaymentContinue;
	
	//place order
	@FindBy(css = "#save")
	WebElement ContractVerify;
	
	
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
	
	
	public  void Payment(String AdminDesignation,String ApprovalDesignation, String Filepath)
	{
		SelectByIndex(PAO,1);
		Type(DesAdm,AdminDesignation);
		Type(DesFin,ApprovalDesignation);
		ClickOn(GST);
		Type(FinApproval,Filepath);
		ClickOn(PaymentContinue);
	}
	
	public void ContractAndOtp(String OTP)
	{
		SwitchToFrameByValue(driver,iframe);
		ScrollAndClick(Save);
		SwitchToWindow(driver);
		ScrollAndClick(ClickOTP);
		Type(EnterOTP, OTP);
		WaitUntilElementClickable(VerifyOTP);
		ClickOn(VerifyOTP);
		
	}
}
