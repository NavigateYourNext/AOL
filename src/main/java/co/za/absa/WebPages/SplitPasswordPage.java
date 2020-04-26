package co.za.absa.WebPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;
import com.relevantcodes.extentreports.LogStatus;

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
		logger = Logger.getLogger(SplitPasswordPage.class);
	}


	public HomePage enterParaphrase(String paraPhrase)
	{
		try
		{
			Robot r = new Robot();
			Actions action = new Actions(driver);
			
			
			String paraPhraseValues = firstBlockOfPassword.getAttribute("showmehow");
			extentTest.log(LogStatus.INFO, "Required Paraphrase Characters Are: "+paraPhraseValues);
			logger.info("Required Paraphrase Characters Are :"+paraPhraseValues);
			
			String[] extractedDigits = SplitParaPhrase.splitPara(paraPhraseValues);
			String[] getExtractedCharacters = SplitParaPhrase.getRequiredCharacters(extractedDigits, paraPhrase);
			logger.info("Entered Characters Are: "+getExtractedCharacters[0]+","+getExtractedCharacters[1]+","+getExtractedCharacters[2]);
			
			firstBlockOfPassword.click();
			firstBlockOfPassword.sendKeys(getExtractedCharacters[0]);
			
			/*Thread.sleep(1000);
			action.sendKeys(getExtractedCharacters[1]).build().perform();
			Thread.sleep(1000);
			action.sendKeys(getExtractedCharacters[2]).build().perform();*/
			
			
			int keyCode_1 = KeyEvent.getExtendedKeyCodeForChar(getExtractedCharacters[1].charAt(0));
			r.keyPress(keyCode_1);
			r.keyRelease(keyCode_1);
			
			
			int keyCode_2 = KeyEvent.getExtendedKeyCodeForChar(getExtractedCharacters[2].charAt(0));
			r.keyPress(keyCode_2);
			r.keyRelease(keyCode_2);
			
			/*System.out.println(paraPhraseValues);
			System.out.println(getExtractedCharacters[0]+" "+getExtractedCharacters[1]+" "+getExtractedCharacters[2]);
		    */
			
			extentTest.log(LogStatus.INFO, "Entered Characters Are: "+getExtractedCharacters[0]+","+getExtractedCharacters[1]+","+getExtractedCharacters[2]);
			
			logger.info("Entered Characters Are: "+getExtractedCharacters[0]+","+getExtractedCharacters[1]+","+getExtractedCharacters[2]);
			
			loginButton.click();
			
			extentTest.log(LogStatus.INFO, "Login Button Clicked");

		}
		catch(Exception e)
		{
			System.out.println("Exception Occured While Entering ParaPhrase -> "+e.getMessage());
		}

		return new HomePage();
	}
}
