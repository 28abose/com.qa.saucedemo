package com.saucedemo.test;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.saucedemo.base.DriverScript;
import com.saucedemo.pages.AboutusPage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.LogoutPage;
import com.saucedemo.utils.ExcelUtils;
import com.saucedemo.utils.HelperUtil;

public class BaseTest extends DriverScript{
	
	
	
	protected static ExtentHtmlReporter extent;
	protected static ExtentReports report;
	protected static ExtentTest Logger;
	
	HomePage homepage;
	LoginPage loginpage;
	CartPage cartpage;
	LogoutPage logoutpage;
	AboutusPage aboutuspage;
	
	
	public void login() {
		loginpage.enterUsername("standard_user");
		loginpage.enterPassword("secret_sauce");
		loginpage.clickLoginButton();
	}
	
	@BeforeSuite
	public void setUpReport() {
		
		extent = new ExtentHtmlReporter("./reports/index.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeMethod
	public void setUp() {
		initApplication();
		homepage = new HomePage();
		loginpage = new LoginPage();
		cartpage = new CartPage();
		logoutpage = new LogoutPage();
		aboutuspage = new AboutusPage();
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			try 
			{
				Logger.fail("test-failed", 
						MediaEntityBuilder.createScreenCaptureFromPath(HelperUtil.captureScreen(driver)).build());
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		report.flush();
		quitDriver();
	}
	
	@DataProvider(name="saucedemo")
	public Object [][] testData(){
		ExcelUtils excel = new ExcelUtils("./src/test/resources/testdata/saucedemo.xlsx");
		int rows = excel.getRowCount(0);
		
		Object data[][] = new Object[rows][2];
		
		for(int i=0; i<rows; i++) {
			data[i][0] = excel.getCellData(0, i, 0);
			data[i][1] = excel.getCellData(0, i, 1);	
		}
				
		return data;
	}
	
}
