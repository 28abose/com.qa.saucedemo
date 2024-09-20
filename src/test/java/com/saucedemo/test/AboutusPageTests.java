package com.saucedemo.test;

import java.time.Duration;

import org.testng.annotations.Test;

import com.saucedemo.pages.AboutusPage;

public class AboutusPageTests extends BaseTest {
	
	@Test
	
	public void testABoutPage() throws InterruptedException {
		Logger = report.createTest("Test for About Page starts");
		 login();
		 Logger = report.createTest("User logs in Successfully");
		 aboutuspage.clickonburgerMenu();
		 Logger.pass("User clicks on the Burgermenu on Left");
		 aboutuspage.clickonAboutlink();
		 Logger.pass("User Clicks on the About Link Successfully");
		 Thread.sleep(5000);

		Logger = report.createTest("Test for Image displayed");
		aboutuspage.saucelabsimagedisplayed();
		Logger.pass("The saucelab image is displayed");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Logger.pass("Waited few seconds");
		Logger = report.createTest("Test for Products link Displayed");
		String expected_Text ="Products";
		String actual_Text = aboutuspage.getproductTextElement();
		aboutuspage.validateText( actual_Text, expected_Text)	; 
		Logger.pass("Validated that the page is displaying the ProductLink");
		 Thread.sleep(4000);
		 Logger.pass("tesr passses");		 
	}
	
	

}