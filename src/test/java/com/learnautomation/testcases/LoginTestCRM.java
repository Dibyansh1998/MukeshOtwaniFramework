package com.learnautomation.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utilities.ExcelDataProvider;

public class LoginTestCRM extends BaseClass {

	@Test
	public void loginApp() throws IOException {

		LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
		LoginPage.LoginCRM(excel.getStringData("LogIn", 0, 0), excel.getStringData("LogIn", 0, 1));

	}

}
