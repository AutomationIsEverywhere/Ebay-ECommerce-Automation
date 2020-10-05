package com.Ebay.TestCases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ebay.PageObjects.LoginPage;

import static org.testng.Assert.assertTrue;

import java.lang.*;


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
	    
	    if(driver.findElement(By.xpath("//*[text()='Please verify yourself to continue']")).isDisplayed())
	    {
	    	logger.info("Captcha present.....Manual Verification");	
	    	Thread.sleep(15000);
	    }
	    else
	    {
	    	Thread.sleep(3000);
	    }
	    
	    login.TypeUsername(email);
	    logger.info("Typed in the username");	
	    Thread.sleep(2000);
	    
	    login.ClickContinueButton();
	    
	    Thread.sleep(2000);
	    login.TypePassword(password);    
	    logger.info("Typed in the password");	
	    Thread.sleep(2000);
	    
		login.ClickLogin();
		logger.info("Clicked the login button");	
		
		//Captcha Verification process Time
		logger.info("Captcha present.....Manual Verification");	
		Thread.sleep(15000);
		
		Boolean ButtonPresent=driver.findElement(By.xpath("//button[@id='gh-ug']")).isDisplayed();
		if(ButtonPresent.equals(true))
		{
			Assert.assertTrue(true);
			logger.info("Login Successfull....");
			logger.info("Login Test Passed successfully");
			System.out.println("Login Test Passed");
		}
		else
		{
			logger.info("Login Failed....");
			logger.info("Login Test Failed");
			System.out.println("Login Test Failed");
		}
	}
}
