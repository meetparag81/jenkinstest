package com_crm_qa_base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Listeners;

import com_crm_qa_util.Test_Util;
import com_crm_qa_util.WebListener;
@Listeners(com_crm_qa_util.Test_Util.class)
public class TestBase 
{
	public static WebDriver driver;
	  public static Properties prop;
	  //public static WebEventListener eventListener;
	  
	    public TestBase() 
	    {
	    	try 
				{
					 prop = new Properties();

					 FileInputStream ip = new FileInputStream("C:\\Users\\Parag\\git\\freecrmgit\\Crm\\src\\main\\java\\com_crm_qa_config\\config.properties");

					 

					prop.load(ip);
				} 
	    	catch (Exception e) 
	    	{
					// TODO Auto-generated catch block
					e.printStackTrace();
	    	}
		}
	    
	  
	  public static void initalization()
	  {
		  String browsername=prop.getProperty("browser");
			 if(browsername.equals("firefox"))
			 {
				 System.setProperty("webdriver.gecko.driver","G:\\Javaprogramming\\Selenium\\Selenium Setup\\chromedriver\\for 65\\chromedriver.exe");
					driver = new FirefoxDriver(); 
			 }
			 else if(browsername.equals("chrome"))
			 {
				 System.setProperty("webdriver.chrome.driver" ,"G:\\Javaprogramming\\Selenium\\Selenium Setup\\chromedriver\\for 65\\chromedriver.exe");
					driver = new ChromeDriver(); 
			 }
			 
			 EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
				// Now create object of EventListerHandler to register it with EventFiringWebDriver
				WebDriverEventListener eventListener = new WebListener();
				e_driver.register(eventListener);
				driver = e_driver;
			 
			 //System.out.println("Browserlaunched");
			
			//driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().pageLoadTimeout(Test_Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Test_Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
			
	

}
}
