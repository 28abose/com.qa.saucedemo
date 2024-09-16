package com.saucedemo.test;

import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

	//@Test

	public void testCartItems() throws InterruptedException {
		Logger = report.createTest("Test Add Item to shopping cart");
		login();
		Logger.pass("User login successfully");
		Thread.sleep(3000);
		cartpage.clickCartButton();
		Logger.pass("User clicked the add to cart button successfully");
		cartpage.clickCartLink();
		Logger.info("User clicked the link to cart button successfully");
		Thread.sleep(3000);
		String expectedText = "Sauce Labs Bike Light";
		String actualText = cartpage.getTextElement();
		cartpage.validateItemText(actualText, expectedText);
		Logger.pass("Validated added item to cart successfully");
}
	@Test
	public void testAddAndRemoveitem() throws InterruptedException {
		login();
		cartpage.clickCartButton();
		Thread.sleep(3000);
		cartpage.clickRemoveButton();
		Thread.sleep(3000);
}
	//@Test
	public void testCheckout() {
		login();
		cartpage.clickCartButton();
		cartpage.clickCartLink();
		cartpage.clickCheckoutButton();
	}
	//@Test
	public void testCheckoutForm() throws InterruptedException {
		testCheckout();
		cartpage.fillForm();
		Thread.sleep(3000);
		cartpage.clickContinueCheckoutButton();
		cartpage.clickFinishChekoutButton();
		Thread.sleep(3000);
	    String pageTitle = homepage.getHomePageTitle();
		System.out.println(pageTitle);
		String actualTitle = "Swag Labs";
		if (pageTitle.equals(actualTitle)) {
		System.out.println("TestPassed");
		}
		else 
		{
			System.out.println("Testfailed");
		}
		
		
	}

		@Test
	public void testCheckoutDetails() throws InterruptedException {
			testCheckout();
		cartpage.fillForm();
			Thread.sleep(3000);
			cartpage.clickContinueCheckoutButton();
			//testCheckoutForm();
		cartpage.veryfyPaymentSummary();
	}

}
