package co.za.absa.WebPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.za.absa.BaseClass.BaseClass;
import co.za.absa.TestUtilities.SplitParaPhrase;

public class SplitPasswordPage extends BaseClass
{
	@FindBy(xpath="//input[@class='pf pf2 ui-keyboard-input-selected vi-activeElement']")
	public WebElement firstBlockOfPassword;

	@FindBy(xpath="//div[@class='ui-button-center' and text()='Logon']")
	public WebElement loginButton;

	public SplitPasswordPage()
	{
		PageFactory.initElements(driver, this);
	}


	public HomePage enterParaphrase(String paraPhrase)
	{
		try
		{
			Robot r = new Robot();
			Actions action = new Actions(driver);
			
			
			String paraPhraseValues = firstBlockOfPassword.getAttribute("showmehow");
			
			String[] extractedDigits = SplitParaPhrase.splitPara(paraPhraseValues);
			String[] getExtractedCharacters = SplitParaPhrase.getRequiredCharacters(extractedDigits, paraPhrase);

			firstBlockOfPassword.click();
			firstBlockOfPassword.sendKeys(getExtractedCharacters[0]);
			
		
			action.sendKeys(getExtractedCharacters[1]).build().perform();
			action.sendKeys(getExtractedCharacters[2]).build().perform();
			
			/*System.out.println(paraPhraseValues);
			System.out.println(getExtractedCharacters[0]+" "+getExtractedCharacters[1]+" "+getExtractedCharacters[2]);
		    */
			
			loginButton.click();

		}
		catch(Exception e)
		{
			System.out.println("Exception Occured While Entering ParaPhrase");
		}

		return new HomePage();
	}
}
