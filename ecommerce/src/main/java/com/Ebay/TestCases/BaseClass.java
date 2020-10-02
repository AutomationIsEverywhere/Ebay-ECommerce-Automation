package com.Ebay.TestCases;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;

public class BaseClass {

	public String baseURL="https://www.ebay.com/";
	public String email="rahulbhagwat94@gmail.com";
	public String password="Suppu34$";
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		logger=Logger.getLogger("Flipkart Automation");
		//PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
}
