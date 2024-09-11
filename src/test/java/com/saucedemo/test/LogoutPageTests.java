package com.saucedemo.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.LogoutPage;

public class LogoutPageTests extends BaseTest {
	

	@Test
	public void testLogoutFunctionality() throws InterruptedException {
		login();
		Logger = report.createTest("Click on the Burger Menu");
		logoutpage.click_on_left_Menu();
		Logger = report.createTest("Clicked on the Burger Menu");
		Thread.sleep(4000);
		Logger = report.createTest("check left meny lists are displayed");
		logoutpage.check_left_Menu_display();
		Logger = report.createTest("left menu lists are  all displayed");
		//assert.assertEquals(null, null)
		logoutpage.click_on_logout();
		Logger.pass("User able to logput");

		Logger = report.createTest("Successfull logout");
		Logger = report.createTest("Getting the Title for Swaglab");
		String get_Text = loginpage.getLoginPageTitle();
		Logger.pass(get_Text);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Logger = report.createTest("Validate the blankUsername is displayed");
		boolean flag = logoutpage.blankusername_displayed();
		Assert.assertTrue(flag);
		Logger.pass("Validated the Username is Blank");
		System.out.println("Is Username Blank" + flag);
		Thread.sleep(4000);
		
		
			
		
	}

}
