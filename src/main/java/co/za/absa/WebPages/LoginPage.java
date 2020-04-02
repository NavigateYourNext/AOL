package co.za.absa.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		pinNumber.sendKeys(pin);
		nextButton.click();
		
		System.out.println("Login Succesful");
		
		return new SplitPasswordPage();
	}
	
}
