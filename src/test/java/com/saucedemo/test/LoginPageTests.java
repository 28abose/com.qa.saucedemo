package com.saucedemo.test;

import org.testng.Assert;
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

	@Test(priority = 3)
	public void testUsernameBlank() throws InterruptedException {
		Logger = report.createTest("test login functionality without username");
		loginpage.enterUsername(" ");
		Logger.pass("username field is blank");
		loginpage.enterPassword("secret_sauce");
		Logger.pass("entered password successfully");
		loginpage.clickLoginButton();
		Logger.pass("user clicked the login button");
		Thread.sleep(3000);
		loginpage.isBlankUsernameErrorPresent();
		Logger.pass("user not able to logged in ");
	}
	
	@Test(priority = 4)
	public void testPasswordBlank() throws InterruptedException {
		Logger = report.createTest("test login functionality without password");
		loginpage.enterUsername("standard_user");
		Logger.pass("entered username successfully");
		loginpage.enterPassword(" ");
		Logger.pass("password field is blank");
		loginpage.clickLoginButton();
		Logger.pass("user clicked the login button");
		Thread.sleep(3000);
		loginpage.isBlankPasswordErrorPresent();
		Logger.pass("user not able to logged in ");
	}
	
	//@Test(priority = 5)
	public void testLoginPageTitleFailed() {
		Logger = report.createTest("test login page title Failed");
		String pageTitle = loginpage.getLoginPageTitle();
		Logger.pass("got the login page title");
		Assert.assertTrue(pageTitle.contains("Swag Swag Labs"));
		Logger.pass("login page title matched");
	}
}
