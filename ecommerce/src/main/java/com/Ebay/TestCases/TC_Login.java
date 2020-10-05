package com.Ebay.TestCases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.lang.*;

import com.Ebay.PageObjects.LoginPage;

public class TC_Login extends BaseClass{

	
	@Test
	public void LoginTest() throws InterruptedException
	{
		driver.get(baseURL);
		LoginPage login=new LoginPage(driver);
		
	    Thread.sleep(2000);
	    
	    //Test Login
	    login.ClickLink();
	    logger.info("Sign In link clicked");	
	    Thread.sleep(6000);
	    login.TypeUsername(email);

	    Thread.sleep(2000);
	    login.ClickContinueButton();
	    
	    Thread.sleep(2000);
	    login.TypePassword(password);    
	    
	    Thread.sleep(6000);
		login.ClickLogin();
	
		Thread.sleep(100000);
		
		Boolean ButtonPresent=driver.findElement(By.xpath("//button[@id='gh-ug']")).isDisplayed();
		if(ButtonPresent.equals(true))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed successfully");
			System.out.println("Login Test Passed");
		}
		else
		{
			logger.info("Login Test Failed");
			System.out.println("Login Test Failed");
		}
	}
}
