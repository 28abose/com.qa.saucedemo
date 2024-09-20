package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saucedemo.base.DriverScript;

public class AboutusPage extends DriverScript {
	// locators
	@FindBy(xpath = "//div[@class='bm-burger-button']/button[@id='react-burger-menu-btn']") 
	private WebElement burgerMenu;
	
	@FindBy(id= "about_sidebar_link") 
	private WebElement aboutlink;
	@FindBy(xpath="//div[@class='MuiBox-root css-lwb5go']/img[@alt='Saucelabs']") 
	private WebElement saucelabImage;
	@FindBy(xpath = "//div[@class='MuiStack-root css-e3zn88']//span[@class='MuiTypography-root MuiTypography-buttonLabelNav css-1pj3is7' and contains(text(),'Products')]")
	private WebElement productlink;
	
	
	// initalization
	public AboutusPage() {
		PageFactory.initElements(driver, this);
	}
	// methods

// click on the burgermenu
	public void clickonburgerMenu() {
		burgerMenu.click();
		
	}
	public void clickonAboutlink() {
		aboutlink.click();
	}
	
	public boolean saucelabsimagedisplayed() {
		return saucelabImage.isDisplayed();
		
	}

	public void validateText(String text_Actual, String text_Expected) {
		Assert.assertEquals(text_Actual, text_Expected);
	}
	public String getproductTextElement() {
		return getText(productlink);
	}


}
