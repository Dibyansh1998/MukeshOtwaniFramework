package com.learnautomation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	@BeforeSuite
	public void setupsuite() throws IOException
	{
		excel= new ExcelDataProvider();
		config= new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStringURL());
	}
	
	@AfterClass
	public void teardown() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BrowserFactory.quitBrowser(driver);
	}
}
