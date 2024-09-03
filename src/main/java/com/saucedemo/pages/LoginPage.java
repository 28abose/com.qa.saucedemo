package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.base.DriverScript;

public class LoginPage extends DriverScript {

	// ***************************** Page Locators ***********************************
	@FindBy(id = "user-name")
	private WebElement usernameTextbox;
	@FindBy(id = "password")
	private WebElement passwordTextbox;
	@FindBy(id = "login-button")
	private WebElement loginButton;
	@FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3") private WebElement BlankUsernameError;
	@FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3") private WebElement BlankPasswordError;

	// ***************************** Page Initialization *****************************

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// ***************************** Page Methods/Action *****************************

	public void enterUsername(String username) {
		usernameTextbox.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTextbox.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isBlankUsernameErrorPresent() {
		return BlankUsernameError.isDisplayed();
	}
	
	public boolean isBlankPasswordErrorPresent() {
		return BlankPasswordError.isDisplayed();
	}
	
}
