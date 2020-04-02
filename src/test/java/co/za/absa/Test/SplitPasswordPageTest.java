package co.za.absa.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import co.za.absa.BaseClass.BaseClass;
import co.za.absa.WebPages.HomePage;
import co.za.absa.WebPages.LoginPage;
import co.za.absa.WebPages.SplitPasswordPage;

public class SplitPasswordPageTest extends BaseClass
{
	LoginPage loginPage;
	SplitPasswordPage splitPasswordPage;
	HomePage homePage;
	
	public SplitPasswordPageTest()
	{
		super();
	}
	
	@BeforeMethod
	@Parameters({"accountNumber","pinNumber"})
	public void setUp(String accountNumber,String pinNumber) throws Exception
	{
		closeExistingBrowser();
		initialisation();
		loginPage = new LoginPage();
		splitPasswordPage = loginPage.loginUser(accountNumber, pinNumber);
	}
	
	@Test
	@Parameters({"passphrase"})
	public void enterPara(@Optional("password1")String passphrase)
	{
		homePage = splitPasswordPage.enterParaphrase(passphrase);
		
	}
}
