package com.learnautomation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	
	public static WebDriver startApplication(WebDriver driver,String BrowserName, String URL)
	{
		if(BrowserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(BrowserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
			driver= new EdgeDriver();
		}
		else if(BrowserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("We don't support any browser");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
		
		
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.close();
	}
	
	
	
	

}
