package co.za.absa.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import co.za.absa.BaseClass.BaseClass;
import co.za.absa.WebPages.LoginPage;
import co.za.absa.WebPages.SplitPasswordPage;

public class LoginPageTest extends BaseClass 
{
	LoginPage loginPage;
	SplitPasswordPage splitPasswordPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		closeExistingBrowser();
		initialisation();
	}
	
	@Test
	@Parameters({"accountNumber","pinNumber"})
	public void loginUser(@Optional("4096492154")String accountNumber,@Optional("10024")String pinNumber)
	{
		loginPage = new LoginPage();
		splitPasswordPage = loginPage.loginUser(accountNumber, pinNumber);
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeDriver();
	}
	
}
