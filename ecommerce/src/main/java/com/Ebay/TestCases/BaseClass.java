package com.Ebay.TestCases;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Ebay.Utilities.ReadConfig;

import org.testng.annotations.AfterClass;

public class BaseClass {

	ReadConfig config=new ReadConfig();
	public String baseURL=config.getAppURL();
	public String email=config.getUsername();
	public String password=config.getPassword();
	public static WebDriver driver;
	static Logger logger = Logger.getLogger(BaseClass.class);
	
	@Parameters("browser")
	@BeforeClass
	public void SetUp(String br)
	{
	    
		logger=Logger.getLogger("Ebay Automation");
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",config.getChromePath());
		driver=new ChromeDriver();
		}
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
}
