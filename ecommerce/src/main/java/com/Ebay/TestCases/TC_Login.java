package com.Ebay.TestCases;

import org.testng.annotations.Test;


import com.Ebay.PageObjects.LoginPage;

public class TC_Login extends BaseClass{

	
	@Test
	public void LoginTest()
	{
		driver.get(baseURL);
		LoginPage login=new LoginPage(driver);
		
		login.ClickLink();
		logger.info("Sign In link clicked");
	   System.out.println("Clicked the sign in button");
	}
}
