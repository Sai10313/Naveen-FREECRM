package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
public static WebDriver driver;

public static Properties prop;

	public TestBase() {
		
		
		try {
			prop=new Properties();
			FileInputStream fip=new FileInputStream("C:\\Users\\SG67126\\eclipse-workspace\\FreeCRMTest\\src\\"
					+ "main\\java\\com\\crm\\qa\\config\\config.properties");
			try {
				prop.load(fip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void intialization()
	{
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SG67126\\eclipse-workspace\\FreeCRMTest"
					+ "\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			System.setProperty("webdrivr.edge.driver", browser);
			driver=new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
	
	

}
