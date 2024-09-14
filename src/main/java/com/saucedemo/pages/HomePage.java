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

	// ***************************** Page Locators *****************************
	@FindBy(id = "react-burger-menu-btn") private WebElement burgerMenu;
	@FindBy(id = "about_sidebar_link") private WebElement aboutLink;
	@FindBy(xpath = "//div[text()='Swag Labs']") private WebElement SwaglabsText;
	@FindBy(xpath = "//span[text()='Products']") private WebElement ProductsText;

	@FindBy(className = "inventory_item_price") private List<WebElement> priceList;
	@FindBy(className = "inventory_item_name") private List<WebElement> nameList;
	@FindBy(className = "product_sort_container") private WebElement dropdownFilter;
	@FindBy(xpath = "//div[@class = 'inventory_list']/div") private List<WebElement> ProductsGrid;

	// ***************************** Page Initialization *****************************

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// ***************************** Page Methods/Action *****************************

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

	public int getProductsGridSize() {
		return ProductsGrid.size();
	}

	// Method to capture prices from a list of WebElements
	public List<Double> beforeFilterPrice() {
		List<Double> beforeFilterPriceList = new ArrayList<>();
		for (WebElement p : priceList) {
			beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}
		System.out.println("Inside beforeFilterPrice method");
		return beforeFilterPriceList;
	}

	// Method to capture Product names from a list of WebElements
	public List<String> beforeFilterName() {
		List<String> beforeFilterNameList = new ArrayList<>();
		for (WebElement n : nameList) {
			beforeFilterNameList.add(n.getText());
		}
		System.out.println("Inside beforeFilterName method");
		return beforeFilterNameList;
	}

	// Method to apply the filter
	public void selectFilter(String text) {
		Select dropdown = new Select(dropdownFilter);
		dropdown.selectByVisibleText(text);
		System.out.println("Inside selectFilter method");
	}

	// Method to capture prices from a list of WebElements
	public List<Double> afterFilterPrice() {
		List<Double> afterFilterPriceList = new ArrayList<>();
		for (WebElement p : priceList) {
			afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}
		System.out.println("Inside beforeFilterPrice method");
		return afterFilterPriceList;
	}

	// Method to capture names from a list of WebElements
	public List<String> afterFilterName() {
		List<String> afterFilterNameList = new ArrayList<>();
		for (WebElement n : nameList) {
			afterFilterNameList.add(n.getText());
		}
		System.out.println("Inside afterFilterName method");
		return afterFilterNameList;

	}

	// Method to sort the listPrice
	public List<Double> sortPriceAscending(List<Double> priceList) {
		Collections.sort(priceList);
		System.out.println("Inside sortPriceAssending method");
		return priceList;
	}

	// Method to sort the list by name
	public List<String> sortNameAscending(List<String> nameList) {
		Collections.sort(nameList);
		System.out.println("Inside sortNameAscending method");
		return nameList;
	}

	// Method to reverse the listPrice
	public List<Double> sortPriceDescending(List<Double> priceList1) {
		Collections.reverse(priceList1);
		System.out.println("Inside sortPriceDescending method");
		return priceList1;
	}

	// Method to reverse the list by name
	public List<String> sortNameDescending(List<String> nameList) {
		Collections.reverse(nameList);
		System.out.println("Inside sortNameDescending method");
		return nameList;
	}

	// Method to compare the listsPrice
	public void compareLists(List<Double> list1, List<Double> list2) {
		System.out.println("Inside compareLists begining method");
		Assert.assertEquals(list1, list2);
		System.out.println("Inside compareLists ending method");
	}

	// Method to compare the lists by name
	public void compareListsByName(List<String> list1, List<String> list2) {
		System.out.println("Inside compareListsByName begining method");
		Assert.assertEquals(list1, list2);
		System.out.println("Inside compareListsByName ending method");
	}
}
