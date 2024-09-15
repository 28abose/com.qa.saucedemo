package com.saucedemo.test;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
	
		
	//@Test(priority = 1)
	public void testLoginPageTitle() {
		Logger = report.createTest("test login page title");
		String pageTitle = loginpage.getLoginPageTitle();
		Logger.pass("got the login page title");
		Assert.assertTrue(pageTitle.contains("Swag Labs"));
		Logger.pass("login page title matched");
	}
	
	//@Test(priority = 2,dataProvider ="saucedemo")
	public void testLoginFunction(String username, String password) throws InterruptedException {
		Logger = report.createTest("test login functionality");
		loginpage.enterUsername(username);
		Logger.pass("entered username successfully");
		loginpage.enterPassword(password);
		Logger.pass("entered password successfully");
		loginpage.clickLoginButton();
		Logger.pass("user logged in successfully");
		boolean flag = homepage.isProductsTextPresent();
		Assert.assertTrue(flag);
		Logger.pass("validated ProductsText is present in the page");
		System.out.println(flag);
		Thread.sleep(3000);
	}

	//@Test(priority = 3)
	public void testUsernameBlank() throws InterruptedException {
		Logger = report.createTest("test login functionality without username");
		loginpage.enterUsername("");
		Logger.pass("username field is blank");
		loginpage.enterPassword("secret_sauce");
		Logger.pass("entered password successfully");
		loginpage.clickLoginButton();
		Logger.pass("user clicked the login button");
		Thread.sleep(3000);
		loginpage.isBlankUsernameErrorPresent();
		Logger.pass("user not able to logged in ");
		String errorTextActual = loginpage.getTextUsernameError();
		String errorTextExpected = "Epic sadface: Username is required";
		loginpage.validateErrorMessage(errorTextActual, errorTextExpected);
		Logger.pass("validated the error message");
	}
	
	//@Test(priority = 4)
	public void testPasswordBlank() throws InterruptedException {
		Logger = report.createTest("test login functionality without password");
		loginpage.enterUsername("standard_user");
		Logger.pass("entered username successfully");
		loginpage.enterPassword("");
		Logger.pass("password field is blank");
		loginpage.clickLoginButton();
		Logger.pass("user clicked the login button");
		Thread.sleep(3000);
		loginpage.isBlankPasswordErrorPresent();
		Logger.pass("user not able to logged in ");
		String errorTextActual = loginpage.getTextPasswordError();
		String errorTextExpected = "Epic sadface: Password is required";
		loginpage.validateErrorMessage(errorTextActual, errorTextExpected);
		Logger.pass("validated the error message");
	}
	

	//@Test(priority = 5)
	public void testUsernamePasswordMismatch() throws InterruptedException {
		Logger = report.createTest("test login functionality without password");
		loginpage.enterUsername("standard");
		Logger.pass("entered invalid username");
		loginpage.enterPassword("1234");
		Logger.pass("entered invalid password");
		loginpage.clickLoginButton();
		Logger.pass("user clicked the login button");
		Thread.sleep(3000);
		loginpage.isBlankPasswordErrorPresent();
		Logger.pass("user not able to logged in ");
		String errorTextActual = loginpage.getTextPasswordError();
		String errorTextExpected = "Epic sadface: Username and password do not match any user in this service";
		loginpage.validateErrorMessage(errorTextActual, errorTextExpected);
		Logger.pass("validated the error message");
	}
	
	//@Test(priority = 6)
	public void testLoginPageTitleFailed() {
		Logger = report.createTest("test login page title Failed");
		String pageTitle = loginpage.getLoginPageTitle();
		Logger.pass("got the login page title");
		Assert.assertTrue(pageTitle.contains("Swag Swag Labs"));
		Logger.pass("login page title matched");
	}
	
	@Test(enabled = false)
	public void testLoginInBaseClass() {
		Logger = report.createTest("test login from BaseClass");
		login();
		Logger.pass("login successfully");
	}
	
}
