package com.saucedemo.test;

import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

	@Test(priority = 1)
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
	@Test(priority = 2)
	public void testAddAndRemoveitem() throws InterruptedException {
		Logger = report.createTest("Test remove item button on homepage");
		login();
		Logger.pass("User login successfully");
		cartpage.clickCartButton();
		Logger.pass(" User adds item successfully from homepage");
		Thread.sleep(3000);
		cartpage.clickRemoveitemCart();
		Logger.pass("Item removed successfully from homepage");
		Thread.sleep(3000);
		cartpage.checkItemRemoved();
        Logger.pass("Item removal is verified");
	}
	
	@Test(priority = 3)
	public void testCheckout() {
		Logger = report.createTest("Test remove item button on homepage");
		login();
		Logger.pass("User login successfully");
		cartpage.checkout();
		Logger.pass(" User successfully clicked checkout button from shopping cart");
	}

	@Test(priority = 4)
	public void testCheckoutForm() throws InterruptedException {
		Logger = report.createTest("Test completion of checkout process");
		login();
		Logger.pass("User login successfully");
		Thread.sleep(3000);
		cartpage.checkout();
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

	@Test(priority = 5)
	public void testCheckoutDetails() throws InterruptedException {
		Logger = report.createTest("Test payment details on checkout finish page");
		testCheckout();
		Logger.pass("User clicked checkout button successfully from shopping cart");
		cartpage.fillForm();
		Logger.pass("User fill user information successfully");
		Thread.sleep(3000);
		cartpage.clickContinueCheckoutButton();
		Logger.pass("User click continue button to last page successfully");
		cartpage.veryfyPaymentSummary();
		Logger.pass("Payment information verified successfully");
	}
	
	// Test for clicking continue button back to home page
	@Test(priority = 6)
	public void testContinuButtonFromCart() {
		Logger = report.createTest("Test checkout button clicking from shopping cart");
		login();
		Logger.pass("User login successfully");
		cartpage.clickCartButton();
		Logger.pass("User adds Item  successfully from homepage");
		cartpage.clickCartLink();
		cartpage.clickContinueShoppingButtonfrmCart();
		Logger.pass("User clicks continue button from cart page");
		homepage.isProductsTextPresent();
        Logger.pass("Verification for navigation back to home page passed");
	}
	
	@Test(priority = 7)
	public void testAllItemRemovedFromCart() throws InterruptedException {
		Logger = report.createTest("Test removing item from shopping cart");
		login();
		Logger.pass("User login successfully");
		cartpage.clickCartButton();
		cartpage.clickCartLink();
		Logger.pass("User adds Item  successfully from homepage");
		Thread.sleep(3000);
		cartpage.clickRemoveitemCart();
		Logger.pass("item is removed successfully");
		Thread.sleep(3000);
		cartpage.checkItemRemoved();
        Logger.pass("Item removal is verified");
	}
	
	// This test removes one item of two from shopping cart
	@Test(priority = 8)
	public void testOneItemRemovedFromCart() throws InterruptedException {
		Logger = report.createTest("Test removing one item from list of items on  shopping cart");
		login();
		Logger.pass("User login successfully");
		cartpage.clickCartButton();
		cartpage.clickCartLink();
		Logger.pass("User adds Item  successfully from homepage");
		Thread.sleep(3000);
		cartpage.clickContinueShoppingButtonfrmCart();
        cartpage.addSecondItem();
		cartpage.clickCartLink();
        Logger.pass("User adds second item to cart");
        cartpage.removeSecondItem();
		int cartItemSize = cartpage.getItemsNumberfromCart();
		if(cartItemSize==1) {
		    Logger.pass("Item removal is verified successfully");
		} else
		{
			Logger.pass("item is not removed");
		}
	}
	
	@Test(priority = 9)
	public void testPaymentDetails() throws InterruptedException {
		Logger = report.createTest("Test payment details on checkout finish page");
		login();
		Logger.pass("User login successfully");
		cartpage.clickCartButton();
		cartpage.clickCartLink();
		Logger.pass("User adds Item  successfully from homepage");
		Thread.sleep(3000);
		cartpage.clickContinueShoppingButtonfrmCart();
        cartpage.addSecondItem();
        Logger.pass("User adds second item to cart"); 
		cartpage.clickCartLink();
		cartpage.clickCheckoutButton();
        Logger.pass("User clicked checkout button successfully from shopping cart");
        cartpage.fillForm();
        Logger.pass("User fill user information successfully");
        cartpage.clickContinueCheckoutButton();
        Logger.pass("User click continue button to last page successfully");
        cartpage.verifyPaymenItemtSummart();
        Logger.pass("items on Payment page verified successfully");
        cartpage.paymentInfo();
        Logger.pass("payment label is verified successfully");
        cartpage.verifyCardNumber();
        Logger.pass("Card number is verified successfully");
        cartpage.shippingInfoDisplay();
        Logger.pass("Shipping information is verified successfully");
        cartpage.verifyDeliveryInfo();
        Logger.pass("Delivery information is verified successfully");
        cartpage.verifyPriceTotalLabel();
        Logger.pass("Price total label is verified successfully");
        cartpage.verifyTotalPrice();
        Logger.pass("Total price is verified successfully");
        cartpage.verifyTax();
        Logger.pass("Tax is verified successfully");
        cartpage.verifyPaymentItemPlusTax();
        Logger.pass("Payment item plus tax is verified successfully");
        cartpage.clickFinishChekoutButton();
        Logger.pass("User click finish button to last page successfully");
        cartpage.verifyThankyouMessage();
        Logger.pass("Thank you message is verified successfully");
	}
	
	
}