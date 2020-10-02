package com.Ebay.PageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver rdriver;
	
    public LoginPage(WebDriver ddriver)
    {
    	rdriver=ddriver;
    	PageFactory.initElements(rdriver, this);
    	
    }
    

    
    @FindBy(linkText="Sign in")
    WebElement LoginLink;
    
    @FindBy(linkText="uid")
    @CacheLookup
    WebElement FUsername;
    
    @FindBy(name="password")
    @CacheLookup
    WebElement FPassword;
    
    @FindBy(name="loginButton")
    @CacheLookup
    WebElement LoginButton;
    
    public void ClickLink()
    {
    	LoginLink.click();
    }
    public void TypeUsername(String uname)
    {
    	FUsername.sendKeys(uname);
    }

    public void TypePassword(String pwd)
    {
    	FPassword.sendKeys(pwd);
    }
    public void ClickLogin()
    {
    	LoginButton.click();
    }
}
