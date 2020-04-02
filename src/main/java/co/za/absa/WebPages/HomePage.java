package co.za.absa.WebPages;

import org.openqa.selenium.support.PageFactory;

import co.za.absa.BaseClass.BaseClass;

public class HomePage extends BaseClass
{
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
}
