package com.saucedemo.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;





public class LogoutPageTests extends BaseTest {

	@Test(priority = 121)
	public void testLogout() {
		
		ExtentTest Logger = extentReports.get().createTest("test Logout functionality");
				
		//Logger = report.createTest("test Logout functionality");
		login();
		Logger.pass("login successfully");
		homepage.clickburgerMenu();
		homepage.clickLogout();
		Logger.pass("logout successfully");
		Assert.assertTrue(loginpage.isLoginButtonPresent());
		Logger.pass("login button shows in the login page");
	}

}
	