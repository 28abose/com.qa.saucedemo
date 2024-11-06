package com.saucedemo.test;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.saucedemo.base.DriverScript;
import com.saucedemo.pages.SauceLabs;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ExcelUtils;
import com.saucedemo.utils.HelperUtil;

public class BaseTest extends DriverScript{
	
	
	
	//protected static ExtentHtmlReporter extent;
	//protected static ExtentReports report;
	//protected static ExtentTest Logger;
	
	private static ThreadLocal<ExtentHtmlReporter> extentHtmlReporter = new ThreadLocal<>();

	protected static ThreadLocal<ExtentReports> extentReports = new ThreadLocal<>(); 

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	
	HomePage homepage;
	LoginPage loginpage;
	CartPage cartpage;
	SauceLabs SauceLabspage;
	
	
	//This method is used to login to the application before executing anything in the homepage
	public void login() {
		loginpage.enterUsername("standard_user");
		loginpage.enterPassword("secret_sauce");
		loginpage.clickLoginButton();
	}
	
	
	//@BeforeSuite 
	@BeforeClass
	public void setUpReport() { 
	String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); 

	String reportPath = "./reports/index_" + timestamp + ".html"; 

	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath); 

	ExtentReports report = new ExtentReports(); 

	report.attachReporter(htmlReporter); 

	extentHtmlReporter.set(htmlReporter);

	extentReports.set(report); }
	
	
	@BeforeMethod
	public void setUp() {
		initApplication();
		homepage = new HomePage(getDriver());
		loginpage = new LoginPage(getDriver());
		cartpage = new CartPage(getDriver());
		SauceLabspage = new SauceLabs(getDriver());
	}
	
	@AfterMethod 
	public void tearDown(ITestResult result) { 
	if (result.getStatus() == ITestResult.FAILURE) { 
	try { 
	extentTest.get().fail("test-failed", MediaEntityBuilder.createScreenCaptureFromPath(HelperUtil.captureScreen(getDriver())).build()); 
	} catch (IOException e) {
	e.printStackTrace(); 
	} 
	} 
	extentReports.get().flush(); 
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
