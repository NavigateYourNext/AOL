package co.za.absa.WebPages;

import org.openqa.selenium.support.PageFactory;

import co.za.absa.BaseClass.BaseClass;

public class SplitPasswordPage extends BaseClass
{
	public SplitPasswordPage()
	{
		PageFactory.initElements(driver, this);
	}

}
