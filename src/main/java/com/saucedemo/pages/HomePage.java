package com.saucedemo.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.saucedemo.base.DriverScript;

public class HomePage extends DriverScript {
	
	//***************************** Page Locators *****************************
	@FindBy(id = "react-burger-menu-btn") private WebElement burgerMenu;
	@FindBy(id = "about_sidebar_link") private WebElement aboutLink;
	@FindBy(xpath = "//div[text()='Swag Labs']") private WebElement SwaglabsText;
	@FindBy(xpath = "//span[text()='Products']") private WebElement ProductsText;
	@FindBy(className = "inventory_item_price") private List<WebElement> beforeFilterPrice;
	@FindBy(className = "product_sort_container") private WebElement dropdownFilter;
	
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
	
	public void beforeFilterPrice() {
		List<Double> beforeFilterPriceList = new ArrayList<>();
		for(WebElement p : beforeFilterPrice) {
			beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
			
		}
	}
	
	public void selectFilter(String text) {
		Select dropdown = new Select(dropdownFilter);
		dropdown.selectByVisibleText(text);
	}
	
	public void afterFilterPrice() {
		List<Double> afterFilterPriceList = new ArrayList<>();
		for(WebElement p : beforeFilterPrice) {
			afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}
	}
	
	public void compareFilterValues() {
		//1.before filter capture the price
		List<Double> beforeFilterPriceList = new ArrayList<>();
		//2.remove the $ symbol
		for(WebElement p : beforeFilterPrice) {
			beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
			}
		//3.filter the price from the dropdown
		selectFilter("Price (high to low)");
		//4.after filter capture the price
		List<Double> afterFilterPriceList = new ArrayList<>();
		for(WebElement p : beforeFilterPrice) {
			afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}
		Collections.sort(beforeFilterPriceList); //list will get sorted in ascending order
		Collections.reverse(beforeFilterPriceList); //list will get sorted in descending order
		Assert.assertEquals(afterFilterPriceList, afterFilterPriceList);
	}
	
}


