package com.learnautomation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utilities.BrowserFactory;
import com.learnautomation.utilities.ConfigDataProvider;
import com.learnautomation.utilities.ExcelDataProvider;
import com.learnautomation.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupsuite() throws IOException
	{
		excel= new ExcelDataProvider();
		config= new ConfigDataProvider();
	
		
		String path=System.getProperty("user.dir") +"./Reports/extentReport.html";
		ExtentSparkReporter extent= new ExtentSparkReporter(path);
		report= new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStringURL());
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		
		Thread.sleep(5000);
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod// It will executed each one of the method
	public void teardownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.CaptureScreenShot(driver);
		}
		
		report.flush();
	}
}
