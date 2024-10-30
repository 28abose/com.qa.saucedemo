package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.base.DriverScript;

public class SauceLabs extends DriverScript {
	
	// locators
	@FindBy(xpath = "//div[@class='MuiStack-root css-e3zn88']//span[@class='MuiTypography-root MuiTypography-buttonLabelNav css-1pj3is7' and contains(text(),'Products')]")
	private WebElement productlink;
	
	
	// initalization
	public SauceLabs() {
		PageFactory.initElements(driver, this);
	}
	// methods
	
	public String getSauceLabsPageTitle() {
		return driver.getTitle();
	}



}
