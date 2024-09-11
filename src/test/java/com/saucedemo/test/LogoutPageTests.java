package com.saucedemo.test;

import static org.testng.Assert.assertEquals;

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
		
		
		
	}

}
