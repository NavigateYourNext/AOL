package co.za.absa.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import co.za.absa.TestUtilities.TimeOut;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	
	
	public BaseClass()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/resources/prop.properties");
			prop.load(fis);

		}
		catch(Exception e)
		{
			System.out.println("Properties File Not Loaded Succesfully !!!");
		}

	}
	
	public static void closeExistingBrowser()throws Exception
	{
		try {
			Runtime.getRuntime().exec("taskkill /f /im chrome.exe");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialisation()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TimeOut.implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TimeOut.pageLoadTimeout, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	public static void closeDriver()
	{
		driver.quit();
	}
}