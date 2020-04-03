package co.za.absa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import co.za.absa.BaseClass.BaseClass;

public class LoginPage extends BaseClass
{
	
	@FindBy(id="j_username")
	public WebElement accountNumber;
	
	@FindBy(id="j_pin")
	public WebElement pinNumber;
	
	@FindBy(xpath="//div[text()='Next']")
	public WebElement nextButton;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public SplitPasswordPage loginUser(String accNumber, String pin)
	{
		accountNumber.sendKeys(accNumber);
		extentTest.log(LogStatus.INFO, "Account Number Entered As : "+accNumber);
		pinNumber.sendKeys(pin);
		extentTest.log(LogStatus.INFO, "PIN Number Entered As : "+pin);
		nextButton.click();
		extentTest.log(LogStatus.INFO, "Next Button CLicked");
		
		System.out.println("Login Succesful");
		
		return new SplitPasswordPage();
	}
	
}
