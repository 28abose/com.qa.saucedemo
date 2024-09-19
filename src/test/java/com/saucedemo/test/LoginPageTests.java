package com.saucedemo.test;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
	
		
	@Test(priority = 1)
	public void testLoginPageTitle() {
		Logger = report.createTest("test login page title");
		String pageTitle = loginpage.getLoginPageTitle();
		Logger.pass("got the login page title");
		Assert.assertTrue(pageTitle.contains("Swag Labs"));
		Logger.pass("login page title matched");
	}
	
	@Test(priority = 2,dataProvider ="saucedemo")
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
	
	//@Test(enabled = false)
	public void testLoginInBaseClass() {
		Logger = report.createTest("test login from BaseClass");
		login();
		Logger.pass("login successfully");
	}
	
	@DataProvider(name = "loginDataProvider")
	public Object[][] loginDataProvider() {
	    return new Object[][] {
	    	{"standard_user", " ", false},
	    	{" ", "secret_sauce", false},
	    	{"locked_out_user", "secret_sauce", false},
	        {"standard_user", "secret_sauce", true},
	        {"visual_user", "secret_sauce", true},
	        {"problem_user", "secret_sauce", true},
	        {"error_user", "secret_sauce", true},
	        {"performance_glitch_user", "secret_sauce", true}
	        
	    };
	}

	//@Test(priority = 9,dataProvider ="loginDataProvider")
	public void testLoginFeatures(String username, String password, boolean isValidUser){
		Logger = report.createTest("Test login features using data provider");
		loginpage.performLogin(username, password);
		Logger.pass("entered username, password and clicked login button");
		if(!isValidUser) {
			Assert.assertTrue(loginpage.isErrorTextPresent());
			System.out.println("not a valid user");
			Logger.pass("not a valid user, can't login");
			
		}else {
			Assert.assertTrue(homepage.isProductsTextPresent());
			System.out.println("valid user");
			Logger.pass("valid user, login successful");
		}
		
	}
	

	//@Test(priority = 10)
	// Method to count the number of links in this page
	public void TotalLinkInLoginpage() {
		Logger = report.createTest("test total number of links in LoginPage");
		int actual = loginpage.PageLinkCount();
		System.out.println(actual);
		int expected = 0;
		Logger.pass("Counted links successfully");
		Assert.assertEquals(actual, expected);
		Logger.pass("Validated loginpage have no links");
	}
	
	@Test(priority = 11)
	// Method to Test FooterUsernames are present
	public void TestFooterUsernames() {
		Logger = report.createTest("test Test FooterUsernames are present");
		loginpage.isFooterUsernamesPresent();
		Assert.assertTrue(loginpage.isFooterUsernamesPresent());
		Logger.pass("Validated usernames are present in the footer of loginpage");
	}
	
	@Test(priority = 12)
	// Method to Test FooterUsernames are present
	public void TestFooterPassword() {
		Logger = report.createTest("test Test TestFooterPassword is present");
		loginpage.isFooterPasswordPresent();
		Assert.assertTrue(loginpage.isFooterPasswordPresent());
		Logger.pass("Validated password is present in the footer of loginpage");
	}
	
}
