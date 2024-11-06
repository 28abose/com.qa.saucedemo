package com.saucedemo.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.saucedemo.base.DriverScript;

public class HelperUtil extends DriverScript{
	
	public static String captureScreen(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenPath = "C:/Workspace/Selenium Project/com.qa.saucedemo/reports/screenshots/screen.png";
		try 
		{
			FileHandler.copy(src, new File(screenPath));
		} 
		catch (IOException e) {
			System.out.println("unable to capture the screen");
			e.printStackTrace();
		}
		return screenPath;
	}

	public static String captureScreen(ThreadLocal<WebDriver> driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
