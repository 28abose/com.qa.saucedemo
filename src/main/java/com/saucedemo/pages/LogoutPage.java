package com.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.saucedemo.base.DriverScript;



public class LogoutPage extends DriverScript {
	
	//locators
	@FindBy(xpath="//button[@id='react-burger-menu-btn' and contains(text(),'Open Me')]") 
	private WebElement leftMenu;
	@FindBy(xpath="//nav[@class='bm-item-list']")
	private WebElement leftMenu_lists;
	@FindBy(xpath="//nav[@class='bm-item-list']//a[@id='logout_sidebar_link']")
	private WebElement logoutLink;
	@FindBy(xpath="//div[@class='login-box']/form/div[@class='form_group']/input[@placeholder='Username' and @id='user-name']")
	private WebElement username_field_displayed;
	@FindBy(xpath="//div[contains(text(),'Swag Labs')]") 
	private WebElement swag_lab_text;
	
	
	//initialization
	public LogoutPage() {
		PageFactory.initElements(driver,this);
	}
	
	//methods
	public void click_on_left_Menu() {
		leftMenu.click();
		}
	
	public void check_left_Menu_display() {
		leftMenu_lists.isDisplayed();	
	}
	
	public void click_on_logout() {
		logoutLink.click();
	}
	
	//add the successful logout validation by returning to Login screen

	public boolean blankusername_displayed() {
		return username_field_displayed.isDisplayed();
		}
}
