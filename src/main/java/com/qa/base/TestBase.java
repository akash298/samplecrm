package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestUtil;
import com.qa.util.webeventlistener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	EventFiringWebDriver wb;
	webeventlistener listener;
	
	public TestBase() throws Exception
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:/Users/DELL/workspace/FreeCRMTest/src/main/java/com/qa/config/config.properties");
		
			prop.load(fis);
		
	}
	
	public void initialization() throws Exception
	{
	  String str=prop.getProperty("browser");
		if(str.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://Users//DELL//Desktop//driver//chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else
		{
			if(str.equals("firefox"))
			{
				
			}
			else
			{
				if(str.equals("IE"))
				{
					
				}
					
			}
			
			
		}
		wb=new EventFiringWebDriver(driver);
		listener=new webeventlistener();
		wb.register(listener);
		driver=wb;
		driver.get("https://ui.freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
		
		
	}

}
