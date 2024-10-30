package com.saucedemo.test;

import java.time.Year;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

	@Test(priority = 101)
	public void testHomePageTitle() {
		Logger = report.createTest("test HomePage Title");
		login();
		Logger.pass("login successfully");
		String title = homepage.getHomePageTitle();
		Logger.pass("got the page title");
		Assert.assertTrue(title.contains("Swag Labs"));
		Logger.pass("verified the page title contains Swag Labs");
	}

	@Test(priority = 102)
	public void testSwaglabsText() {
		Logger = report.createTest("test Swag Labs text is present in the header of homepage");
		login();
		Logger.pass("login successfully");
		String actual = homepage.validateSwaglabsText();
		Logger.pass("got the Swag Labs text");
		String expected = "Swag Labs";
		Assert.assertEquals(actual, expected);
		Logger.pass("verified the homepage header contains Swag Labs text/label");
	}

	@Test(priority = 103)
	public void testProductsText() {
		Logger = report.createTest("test Products text is present in the header of homepage");
		login();
		Logger.pass("login successfully");
		boolean value = homepage.isProductsTextPresent();
		Logger.pass("got the boolean value of isProductTextPresent");
		Assert.assertTrue(value);
		Logger.pass("verified the homepage header contains Products text/label");
	}

	@Test(priority = 104)
	public void testDisplaySize() {
		Logger = report.createTest("test Products display size");
		login();
		Logger.pass("login successfully");
		int actual = homepage.getProductsGridSize();
		Logger.pass("product size captured successfully");
		System.out.println("ProductsGridSize : " + actual);
		int expected = 6;
		Assert.assertEquals(actual, expected);
		Logger.pass("verified that 6 products are displayed in the page");
	}
	
	@Test(priority = 110)
	// Method to count the number of links in this page
	public void TotalLinkInHomepage() {
		Logger = report.createTest("test total number of links in HomePage");
		login();
		Logger.pass("Login successfully");
		int actual = homepage.PageLinkCount();
		int expected = 20;
		Logger.pass("Counted links successfully");
		Assert.assertEquals(actual, expected);
		Logger.pass("Validated homepage have 20 links");
	}
	

	@Test(priority = 120)
	// Main method to compare filter values
	public void compareFilterValuesAssending() {
		Logger = report.createTest("test filter : Price (low to high) is working successfully");
		login();
		Logger.pass("Login successfully");

		// Capture prices before filter
		List<Double> beforeFilterPriceList = homepage.beforeFilterPrice();
		Logger.pass("Capture prices before filter");

		// Apply the filter
		homepage.selectFilter("Price (low to high)");
		Logger.pass("Apply the filter : Price (low to high)");

		// Capture prices after filter
		List<Double> afterFilterPriceList = homepage.afterFilterPrice();
		System.out.println(afterFilterPriceList);
		Logger.pass("Capture prices after filter");

		// Sort the before filter price list
		List<Double> sortedBeforeFilterPriceList = homepage.sortPriceAscending(beforeFilterPriceList);
		System.out.println(sortedBeforeFilterPriceList);
		Logger.pass("Sort the before filter price list");

		// Compare the lists
		homepage.compareLists(sortedBeforeFilterPriceList, afterFilterPriceList);
		Logger.pass("Compare the lists that sorted assending order of price");
	}

	@Test(priority = 121)
	// Main method to compare filter values
	public void compareFilterValuesDescending() {
		Logger = report.createTest("test filter : Price (high to low) is working successfully");
		login();
		Logger.pass("Login successfully");
		// Capture prices before filter
		List<Double> beforeFilterPriceList = homepage.beforeFilterPrice();
		Logger.pass("Capture prices before filter");

		// Apply the filter
		homepage.selectFilter("Price (high to low)");
		Logger.pass("Apply the filter : Price (high to low)");

		// Capture prices after filter
		List<Double> afterFilterPriceList = homepage.afterFilterPrice();
		System.out.println(afterFilterPriceList);
		Logger.pass("Capture prices after filter");

		// Sort the before filter price list
		List<Double> sortedBeforeFilterPriceList = homepage.sortPriceAscending(beforeFilterPriceList);
		Logger.pass("Sort the before filter price list");

		// Reverse the before filter price list
		List<Double> sortedBeforeFilterPriceList1 = homepage.sortPriceDescending(sortedBeforeFilterPriceList);
		System.out.println(sortedBeforeFilterPriceList1);
		Logger.pass("Reverse the sorted price to make it descending order");

		// Compare the lists
		homepage.compareLists(sortedBeforeFilterPriceList1, afterFilterPriceList);
		// homepage.compareLists(sortedBeforeFilterPriceList, afterFilterPriceList);
		Logger.pass("Compare the lists that sorted desending order of price");
	}

	@Test(priority = 122)
	// Main method to compare filter values
	public void compareFilterNameAscending() {
		Logger = report.createTest("test filter : Name (A to Z) is working successfully");
		login();
		Logger.pass("Login successfully");

		// Capture prices before filter
		List<String> NameList = homepage.beforeFilterName();
		Logger.pass("Capture names before filter");

		// Apply the filter
		homepage.selectFilter("Name (A to Z)");
		Logger.pass("Apply the filter : Name (A to Z)");

		// Capture names after filter
		List<String> afterFilterNameList = homepage.afterFilterName();
		System.out.println("afterFilterNameList : " + afterFilterNameList);
		Logger.pass("Capture names after filter");

		// Sort the before filter name list
		List<String> sortedNameList = homepage.sortNameAscending(NameList);

		System.out.println("sortedNameList :" + sortedNameList);
		Logger.pass("Sort the before filter name list");

		// Compare the lists
		homepage.compareListsByName(afterFilterNameList, sortedNameList);
		Logger.pass("Compare the lists that sorted assending order of name");

	}

	@Test(priority = 123)
	// Main method to compare filter values
	public void compareFilterNameDesending() {
		Logger = report.createTest("test filter : Name (Z to A) is working successfully");
		login();
		Logger.pass("Login successfully");

		// Capture prices before filter
		List<String> NameList = homepage.beforeFilterName();
		Logger.pass("Capture names before filter");

		// Apply the filter
		homepage.selectFilter("Name (Z to A)");
		Logger.pass("Apply the filter : Name (Z to A)");

		// Capture names after filter
		List<String> afterFilterNameList = homepage.afterFilterName();
		System.out.println("afterFilterNameList : " + afterFilterNameList);
		Logger.pass("Capture names after filter");

		// Sort the before filter name list
		List<String> sortedNameList = homepage.sortNameAscending(NameList);
		Logger.pass("Sort the before filter name list ascending(A to Z)");

		// Sort the before filter name list descending
		List<String> sortedNameListDesc = homepage.sortNameDescending(sortedNameList);
		System.out.println("sortedNameList :" + sortedNameListDesc);
		Logger.pass("Sort the before filter name list descdending(Z to A)");

		// Compare the lists
		homepage.compareListsByName(afterFilterNameList, sortedNameListDesc);
		Logger.pass("Compare the lists that sorted decending order of name");

	}
	
	@Test(priority = 105)
	public void testfooterLinkCount() {
		Logger = report.createTest("Test footer link count is 3");
		login();
		Logger.pass("login successfully");
		int actual = homepage.footerLinkCount();
		Logger.pass("footer link counted");
		int expected = 3;
		Assert.assertEquals(actual,expected);
		Logger.pass("footer link count matched");
	}
	
	@Test(priority = 106)
	public void testTwitter() {
		Logger = report.createTest("Test Twitter link present in the footer");
		login();
		Logger.pass("login successfully");
		homepage.isTwitterDisplayed();
		Logger.pass("Twitter link displayed successfully");
	}
	
	@Test(priority = 107)
	public void testFacebook() {
		Logger = report.createTest("Test Facebook link present in the footer");
		login();
		Logger.pass("login successfully");
		homepage.isFacebookDisplayed();
		Logger.pass("Facebook link displayed successfully");
	}
	
	@Test(priority = 108)
	public void testLinkedIn() {
		Logger = report.createTest("Test LinkedIn link present in the footer");
		login();
		Logger.pass("login successfully");
		homepage.isLinkedInDisplayed();
		Logger.pass("LinkedIn link displayed successfully");
	}
	
	@Test(priority = 109)
	public void testPrivacyPolicyYearCorrect() {
		Logger = report.createTest("Test PrivacyPolicy in the footer contains 2024");
		login();
		Logger.pass("login successfully");
		String yearText = homepage.PrivacyPolicyYearCorrect();
		System.out.println("String yearText : "+yearText);
		Logger.pass("PrivacyPolicy text captured");
		Assert.assertTrue(yearText.contains("2024"));
		Logger.pass("PrivacyPolicy contains year 2024");
		}
	
	@Test(priority = 111)
	public void testPriceValidationBackpack() {
		Logger = report.createTest("test Price Validation for Backpack");
		login();
		Logger.pass("login successfully");
		String priceText = homepage.PriceValidationBackpack();
		
		String expectedPrice = "$29.99";

        // Validate the price
        if (priceText.equals(expectedPrice)) {
            System.out.println("Price validation passed: " + priceText);
            Logger.pass("Price validated successfully");
        } else {
            System.out.println("Price validation failed. Expected: " + expectedPrice + ", but found: " + priceText);
        }
		
}
	
	@Test(priority = 112)
	public void testPriceValidationOnesie() {
		Logger = report.createTest("test Price Validation for Onesie");
		login();
		Logger.pass("login successfully");
		String priceText = homepage.PriceValidationOnesie();
		
		String expectedPrice = "$7.99";

        // Validate the price
        if (priceText.equals(expectedPrice)) {
            System.out.println("Price validation passed: " + priceText);
            Logger.pass("Price validated successfully");
        } else {
            System.out.println("Price validation failed. Expected: " + expectedPrice + ", but found: " + priceText);
        	}
		}
	
	@Test(priority = 121)
		public void testLogout() {
			Logger = report.createTest("test Logout functionality");
			login();
			Logger.pass("login successfully");
			homepage.clickburgerMenu();
			Logger.pass("User clicked burger menu");
			homepage.clickLogout();
			Logger.pass("logout successfully");
			Assert.assertTrue(loginpage.isLoginButtonPresent());
			Logger.pass("login button shows in the login page");
		}
		
		@Test(priority = 122)
		public void testABoutPage() throws InterruptedException {
			Logger = report.createTest("Test for About Page starts");
			login();
			Logger.pass("User logs in Successfully");
			homepage.clickburgerMenu();
			Logger.pass("User clicked burger menu");
			homepage.clickaboutLink();
			Logger.pass("user clicked about link successfully");
			String expected = "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";
			String title = SauceLabspage.getSauceLabsPageTitle();
			Logger.pass("page title captured");
			System.out.println(title);
			Assert.assertEquals(title, expected);
			Logger.pass("page title asserted successfully");
		}
	}
