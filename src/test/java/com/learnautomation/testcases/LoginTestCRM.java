package com.learnautomation.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utilities.Helper;

public class LoginTestCRM extends BaseClass {

	@Test
	public void loginApp() throws IOException {

		logger = report.createTest("LogIn to CRM");

		LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		LoginPage.LoginCRM(excel.getStringData("LogIn", 0, 0), excel.getStringData("LogIn", 0, 1));

		logger.pass("Log In Successfully");

		Helper.CaptureScreenShot(driver);

	}

}
