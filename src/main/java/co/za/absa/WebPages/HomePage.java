package co.za.absa.WebPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import co.za.absa.BaseClass.BaseClass;

public class HomePage extends BaseClass
{
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		logger = Logger.getLogger(HomePage.class);
		
		logger.info("On Homepage");
	}
}
