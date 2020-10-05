package com.Ebay.TestCases;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.Ebay.Utilities.ReadConfig;

import org.testng.annotations.AfterClass;

public class BaseClass {

	ReadConfig config=new ReadConfig();
	public String baseURL=config.getAppURL();
	public String email=config.getUsername();
	public String password=config.getChromePath();
	public static WebDriver driver;
	static Logger logger = Logger.getLogger(BaseClass.class);
	
	@BeforeClass
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver",config.getChromePath());
		driver=new ChromeDriver();
		logger=Logger.getLogger("Ebay Automation");
		
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
}
