package com.saucedemo.test;

import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

	// @Test

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

	// Add and remove item button tested from Home page
	// @Test
	public void testAddAndRemoveitem() throws InterruptedException {
		Logger = report.createTest("Test remove item button on homepage");
		login();
		Logger.pass("User login successfully");
		cartpage.clickCartButton();
		Logger.pass(" User adds successfully from homepage");
		Thread.sleep(3000);
		cartpage.clickRemoveButton();
		Logger.pass("Item removed successfully from homepage");
		Thread.sleep(3000);
		// Have to add assert here?
	}

	 @Test
	public void testCheckout() {
		Logger = report.createTest("Test checkout button clicking from shopping cart");
		login();
		Logger.pass("User login successfully");
		cartpage.clickCartButton();
		Logger.pass("User adds Item  successfully from homepage");
		cartpage.clickCartLink();
		Logger.pass("Shopping cart icon successfully clicked from homepage");
		cartpage.clickCheckoutButton();
		Logger.pass(" User successfully clicked checkout button from shopping cart");

	}

	 @Test
	public void testCheckoutForm() throws InterruptedException {
		Logger = report.createTest("Test completion of checkout process");
     	testCheckout();
		Thread.sleep(3000);
		Logger.pass("User proceed from shopping cart to next page successfully from shopping cart");
		cartpage.fillForm();
		Logger.pass("User fill user information successfully");
		Thread.sleep(3000);
		cartpage.clickContinueCheckoutButton();
		Logger.pass("User click continue button to last page successfully");
		cartpage.clickFinishChekoutButton();
		Logger.pass("User click finish button to last page successfully");
		Thread.sleep(3000);
		String pageTitle = homepage.getHomePageTitle();
		System.out.println(pageTitle);
		String actualTitle = "Swag Labs";
		if (pageTitle.equals(actualTitle)) {
			System.out.println("TestPassed");
		} else {
			System.out.println("Testfailed");
		}
		Logger.pass("checkout process completed successfully");

	}

	 @Test
	public void testCheckoutDetails() throws InterruptedException {
		Logger = report.createTest("Test payment details on checkout finish page");
		testCheckout();
		Logger.pass("User clicked checkout button successfully from shopping cart");
		cartpage.fillForm();
		Logger.pass("User fill user information successfully");
		Thread.sleep(3000);
		cartpage.clickContinueCheckoutButton();
		Logger.pass("User click continue button to last page successfully");
		// testCheckoutForm();
		cartpage.veryfyPaymentSummary();
		Logger.pass("Payment information verified successfully");
	}
	// @Test

	public void testRemoveitemCartpage() throws InterruptedException {
		Logger = report.createTest("Test removal of item from shopping cart");
		login();
		Logger.pass("User login successfully");
		cartpage.clickCartButton();
		Logger.pass("User added item successfully from homepage");
		cartpage.clickCartLink();
		Logger.info("User clicked the link to cart button successfully");
		Thread.sleep(4000);
		cartpage.clickRemoveitemCart();
		Logger.pass("User rmoves item successfully from shopping cart");
		cartpage.verifyItemRemovedFromCart();
		Logger.pass("Item removal is verified successfully");

	}
	
	// Test for clicking continue button back to home page
	public void testContinuButtonFromCart() {
		Logger = report.createTest("Test checkout button clicking from shopping cart");
		login();
		Logger.pass("User login successfully");
		cartpage.clickCartButton();
		Logger.pass("User adds Item  successfully from homepage");
		cartpage.clickCartLink();
		cartpage.clickBContinueShoppingButtonfrmCart();
		
	}

}
