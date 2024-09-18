package com.saucedemo.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.saucedemo.base.DriverScript;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CartPage extends DriverScript {
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	private WebElement cartButton;
	@FindBy(xpath = "//div[@class=\"inventory_item_name\"]")
	private WebElement cartItem;
	@FindBy(xpath = "//a[@class='shopping_cart_link' and @data-test='shopping-cart-link']")
	private WebElement shoppingCartLink;
	@FindBy(id = "remove-sauce-labs-bike-light")
	private WebElement removeItemButton;
	@FindBy(id = "checkout")
	private WebElement checkoutButton;
	@FindBy(id = "first-name")
	private WebElement firstNameField;
	@FindBy(id = "last-name")
	private WebElement lastNameField;
	@FindBy(id = "postal-code")
	private WebElement zipCodeField;
	@FindBy(id = "continue")
	private WebElement checkoutConinueButton;
	@FindBy(id = "finish")
	private WebElement checkoutFinishButton;
	@FindBy(className = "summary_info")
	private WebElement summary;
	@FindBy(className = "summary_subtotal_label")
	private WebElement SummarySubtotal;
	@FindBy(id = "remove-sauce-labs-bike-light")
	private WebElement removeButton;
	@FindBy(xpath = "//div[@class=\"inventory_item_name\"]")
    private WebElement itemOnCart;
	@FindBy(id="continue-shopping")
	private WebElement continuetoHomePageButton;
	

	public CartPage() {
		PageFactory.initElements(driver, this);
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
		shoppingCartLink.click();
	}

	public void clickRemoveButton() {
		removeItemButton.click();

	}

	public void clickCheckoutButton() {
		checkoutButton.click();
	}

	public void enterFirstName(String firstname) {
		firstNameField.sendKeys(firstname);

	}

	public void enterLastName(String lastname) {
		lastNameField.sendKeys(lastname);
	}

	public void enterZipcode(String zipcode) {
		zipCodeField.sendKeys(zipcode);
	}

	public void clickContinueCheckoutButton() {
		checkoutConinueButton.click();

	}

	public void clickFinishChekoutButton() {
		checkoutFinishButton.click();
	}

	public void veryfyPaymentSummary() {
		Assert.assertTrue(summary.isDisplayed(), "Summary is not displayed");
	}

	public void fillForm() {
		enterFirstName("John");
		enterLastName("Doe");
		enterZipcode("60630");
	}

	public void clickRemoveitemCart() {
		removeButton.click();
	}
	

    public boolean isItemDisplayed() {
        try {
            WebElement item = itemOnCart;
            return item.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

   /* public void verifyItemRemovedFromCart() {
        assertFalse("Item should be removed from the cart", isItemDisplayed());
    }*/


/*private void assertFalse(String string, boolean itemDisplayed) {
	// TODO Auto-generated method stub
	
}
*/

public void clickBContinueShoppingButtonfrmCart() {
	continuetoHomePageButton.click();
	
}
    

}
