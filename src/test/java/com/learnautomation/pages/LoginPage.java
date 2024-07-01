package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)// Create Constructor
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement submit;
	
	public void LoginCRM(String usernameApplication, String passwordApplication)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{	
			e.printStackTrace();
		}
		uname.sendKeys(usernameApplication);
		password.sendKeys(passwordApplication);
		submit.click();
	}

}
