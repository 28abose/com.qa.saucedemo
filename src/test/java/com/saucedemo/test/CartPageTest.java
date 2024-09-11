package com.saucedemo.test;

import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {
	//@Test
	public void testAddToCart() {
        login();
cartpage.clickCartButton();
	}
	@Test

public void testCartItems() throws InterruptedException {
		login();	   
		Thread.sleep(3000);
		Logger = report.createTest("Item added to shopping cart");
		cartpage.clickCartButton();
		Logger = report.createTest("item displayed on shopping cart");
		cartpage.clickCartLink();
		Thread.sleep(3000);
		String expectedText = "Sauce Labs Bike Light";
		String actualText = cartpage.getTextElement();
		cartpage.validateItemText(actualText, expectedText);
				
	}
	
}
