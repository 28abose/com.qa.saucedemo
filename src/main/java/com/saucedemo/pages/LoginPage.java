package com.saucedemo.pages;

import java.util.List;

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
	@FindBy(xpath = "//h3[@data-test='error']") private WebElement ErrorText;

	@FindBy(tagName = "a") private List<WebElement> linksInLoginPage;
	
	//@FindBy(linkText = "Twitter") private WebElement Twitter;
	@FindBy(xpath= "//*[@id='login_credentials']/h4") private WebElement FooterUsernames;
	@FindBy(xpath= "//*[@id=\'root\']/div/div[2]/div[2]/div/div[2]/h4") private WebElement FooterPassword;
	
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
	
	public boolean isLoginButtonPresent() {
		return loginButton.isDisplayed();
	}
	
	public boolean isBlankUsernameErrorPresent() {
		return BlankUsernameError.isDisplayed();
	}
	
	public boolean isBlankPasswordErrorPresent() {
		return BlankPasswordError.isDisplayed();
	}
	
	public boolean isErrorTextPresent() {
		return ErrorText.isDisplayed();
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
	
	public String getErrorText() {
		return getText(ErrorText);
	}
	
	// Method to count the number of links in this page
		public int PageLinkCount() {
			int size = linksInLoginPage.size();
			System.out.println("Page link count in this page : "+size);
			for (int i = 1;i<size;i++){
				WebElement a = linksInLoginPage.get(i);
				String c = a.getText();
				System.out.println("Names of the links :"+c);
				}
			return size;
		}
	
//============================================================================================================
	
	//This method is used to perform login for valid and invalid user using dataPtovider named "loginDataProvider"
	public void performLogin(String username,String password ) {
		usernameTextbox.clear();
		usernameTextbox.sendKeys(username);
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
		loginButton.click();
	}
	
	public String getErrorMessageText() {
		return ErrorText.getText();
	}



	public boolean isFooterUsernamesPresent() {
		return FooterUsernames.isDisplayed();
	}
	
	public boolean isFooterPasswordPresent() {
		return FooterPassword.isDisplayed();
	}
	
}
