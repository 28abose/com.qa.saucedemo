package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saucedemo.base.DriverScript;

public class LoginPage extends DriverScript {

	// ***************************** Page Locators ***********************************
	@FindBy(id = "user-name") private WebElement usernameTextbox;
	@FindBy(id = "password") private WebElement passwordTextbox;
	@FindBy(id = "login-button") private WebElement loginButton;
	@FindBy(xpath = "//h3[@data-test='error']") private WebElement BlankUsernameError;
	@FindBy(xpath = "//h3[@data-test='error']") private WebElement BlankPasswordError;
	

	
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
	
	public void validateErrorMessage(String errorTextActual, String errorTextExpected) {
		Assert.assertEquals(errorTextActual, errorTextExpected);
	}
	public String getTextUsernameError() {
		return getText(BlankUsernameError);
	}
	
	public String getTextPasswordError() {
		return getText(BlankPasswordError);
	}

}
