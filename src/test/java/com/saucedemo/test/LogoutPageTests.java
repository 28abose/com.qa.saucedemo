package com.saucedemo.test;

import org.testng.annotations.Test;

import com.saucedemo.pages.LogoutPage;

public class LogoutPageTests extends BaseTest {
	

	@Test
	public void testLogout() throws InterruptedException {
		login();
		Logger = report.createTest("Click on the Burger Menu");
		logoutpage.click_on_left_Menu();
		Logger = report.createTest("Clicked on the Burger Menu");
		Thread.sleep(4000);
		
		
	}

}
