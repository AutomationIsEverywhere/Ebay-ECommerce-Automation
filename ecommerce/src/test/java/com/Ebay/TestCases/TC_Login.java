package com.Ebay.TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ebay.PageObjects.LoginPage;
import com.Ebay.Utilities.XLUtilities;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.*;


public class TC_Login extends BaseClass{

	
	@Test(dataProvider="LoginData")
	public void LoginTest(String user,String pass) throws InterruptedException, IOException
	{
		
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
	    
	    login.TypeUsername(user);
	    logger.info("Typed in the username");	
	    Thread.sleep(2000);
	    
	    login.ClickContinueButton();
	   Thread.sleep(10000);
	 
	    if(driver.findElement(By.xpath("//*[@id='pass']")).isDisplayed()==false)
	    {
	    	System.out.println("Login Test Failed");
	    	logger.info("Login Test Failed");
	    	captureScreen(driver,"LoginTest");
	    	
	    	driver.navigate().to("http://ebay.com");
	    	Thread.sleep(10000);
	   	 
	    	Assert.assertTrue(false);
			
			
	    }
	    else
	    {
	    Thread.sleep(2000);
	    login.TypePassword(pass);    
	    logger.info("Typed in the password");	
	    Thread.sleep(2000);
	    
		login.ClickLogin();
		logger.info("Clicked the login button");	
		
		//Captcha Verification process Time
		logger.info("Captcha present.....Manual Verification");	
		Thread.sleep(20000);
		
		Boolean ButtonPresent=driver.findElement(By.xpath("//button[@id='gh-ug']")).isDisplayed();
		if(ButtonPresent.equals(true))
		{
			Assert.assertTrue(true);
			logger.info("Login Successfull....");
			logger.info("Login Test Passed successfully");
			System.out.println("Login Test Passed");
			Thread.sleep(3000);
			WebElement ButtonP=driver.findElement(By.xpath("//button[@id='gh-ug']"));
			ButtonP.click();
			Thread.sleep(3000);
			login.ClickLogout();
			driver.navigate().to("http://ebay.com");
			
		}
	    }
		
	}
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/Ebay/TestData/LoginData.xlsx";
		
		int rownum=XLUtilities.getRowCount(path, "Sheet1");
		int colcount=XLUtilities.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtilities.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
}
