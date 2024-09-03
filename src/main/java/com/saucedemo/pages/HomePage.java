package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.base.DriverScript;

public class HomePage extends DriverScript {
	
	//***************************** Page Locators *****************************
	@FindBy(id = "react-burger-menu-btn") private WebElement burgerMenu;
	@FindBy(id = "about_sidebar_link") private WebElement aboutLink;
	@FindBy(xpath = "//div[text()='Swag Labs']") private WebElement SwaglabsText;
	@FindBy(xpath = "//span[text()='Products']") private WebElement ProductsText;
	
	
	//***************************** Page Initialization *****************************
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	//***************************** Page Methods/Action *****************************
	
	public void clickburgerMenu() {
		burgerMenu.click();
	}
	
	public void clickaboutLink() {
		aboutLink.click();
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String validateSwaglabsText() {
		return SwaglabsText.getText();
	}

	public boolean isProductsTextPresent() {
		return ProductsText.isDisplayed();
	} 
	
}


