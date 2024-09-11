package com.saucedemo.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.saucedemo.base.DriverScript;
import org.openqa.selenium.WebElement;






public class CartPage extends DriverScript {
	@FindBy(id="add-to-cart-sauce-labs-bike-light") private WebElement cartButton;
	@FindBy(xpath = "//div[@class=\"inventory_item_name\"]") private WebElement cartItem;
	@FindBy(xpath = "//a[@class='shopping_cart_link' and @data-test='shopping-cart-link']") private WebElement cartLink;
	
	public CartPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void clickCartButton() {
		cartButton.click();
		
	}
	public void validateItemText(String textActual, String textExpected) {
		Assert.assertEquals(textActual, textExpected);
	}
	public String getTextElement() {
		return getText(cartItem);
	}
	
 public void clickCartLink() {
	 cartLink.click();
 }
    
	
}

