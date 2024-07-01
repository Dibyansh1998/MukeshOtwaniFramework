package com.learnautomation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	// Screenshot, sync issue, alerts, frames, windows, JavaScriptExecutor

	public static void CaptureScreenShot(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/FreeCRM_" +getCurrentDateTime()+".png"));
		System.out.println("ScreenShot Captured");
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate= new Date();
		return customFormat.format(currentdate);
				
	}

}
