package co.za.absa.WebPages;

import org.apache.log4j.Logger;
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
		logger = Logger.getLogger(LoginPage.class);
	}
	
	public SplitPasswordPage loginUser(String accNumber, String pin)throws Exception
	{
		accountNumber.sendKeys(accNumber);
		extentTest.log(LogStatus.INFO, "Account Number Entered As : "+accNumber);
		Thread.sleep(1000);
		logger.info("Enterd Account Number Is: "+accNumber);
		pinNumber.sendKeys(pin);
		extentTest.log(LogStatus.INFO, "PIN Number Entered As : "+pin);
		logger.info("Enterd PIN Number Is: "+pin);
		nextButton.click();
		extentTest.log(LogStatus.INFO, "Next Button CLicked");
		
		System.out.println("Login Succesful");
		logger.info("Yes, Login Successful");
		
		return new SplitPasswordPage();
	}
	
}
