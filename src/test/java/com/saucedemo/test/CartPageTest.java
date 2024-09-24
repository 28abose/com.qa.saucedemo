package com.saucedemo.test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

	// Add and remove item button tested from Home page
	//@Test
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
	
	//@Test
	public void testCheckout() {
		Logger = report.createTest("Test remove item button on homepage");
		login();
		Logger.pass("User login successfully");
		cartpage.checkout();
		Logger.pass(" User successfully clicked checkout button from shopping cart");
	}

	@Test
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

	//@Test
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
	
	// Test for clicking continue button back to home page
	//@Test
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
	
//	@Test
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
	@Test
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
}