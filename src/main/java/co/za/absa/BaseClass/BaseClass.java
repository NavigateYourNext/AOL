package co.za.absa.BaseClass;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import co.za.absa.TestUtilities.TimeOut;
import co.za.absa.TestUtilities.WebEventListener;


public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event_firing;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	
	public static Logger logger = Logger.getLogger(BaseClass.class);
	static
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		String date = sdf.format(d);
	
		extentReports = new ExtentReports(System.getProperty("user.dir")+"/Extent_Reports/extent_report_"+date+".html",true);
		extentReports.addSystemInfo("Admin", "Akshay Pradip Shete");
		extentReports.addSystemInfo("Host", "HP Windows 10");
		extentReports.addSystemInfo("Date", LocalDateTime.now().toString());	
	}
	
	public BaseClass()
	{
		try
		{
			
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/resources/prop.properties");
			prop.load(fis);
			
			logger.info("Properties File Loaded Successfully");

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
		
		//Register WebDriverEventListener with driver
		event_firing = new EventFiringWebDriver(driver);
		WebEventListener wdl = new WebEventListener();
		event_firing.register(wdl);
		driver = event_firing;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TimeOut.implicitWait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TimeOut.pageLoadTimeout, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		logger.info("URL Loaded Successfully "+prop.getProperty("url"));
	}
	
	public static void closeDriver()
	{
		driver.quit();
		
		logger.info("Driver Closed");
	}
}