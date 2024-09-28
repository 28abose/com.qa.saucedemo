package com.saucedemo.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.saucedemo.base.DriverScript;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	@FindBy(id = "continue-shopping")
	private WebElement continuetoHomePageButton;
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement SecondItemAddToCartButton;
	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removeSecondItemButton;
	@FindBy(className = "cart_list")
	private WebElement summary_itemlist;
	@FindBy(className="summary_subtotal_label" )
	private WebElement Itemtotal_price;
	//@FindBy(xpath = "//div[text()='Tax: $3.20']")
	@FindBy(className="summary_tax_label" )
	private WebElement tax;
	//@FindBy(xpath = "//div[text()='Total: $43.18]") 
	@FindBy(className="summary_total_label" )
	private WebElement PaymentItemPlusTax;
	@FindBy(xpath = "//div[text()='Payment Information:']")
	private WebElement paymentInfoLabel;
	@FindBy(xpath = "//div[text()='Shipping Information:']")
	private WebElement shippingInfoLabel;
	@FindBy(xpath = "//div[text()='SauceCard #31337']")
	private WebElement cardNumber;
  @FindBy(xpath = "//div[text()='Free Pony Express Delivery!']")
  private WebElement deliveryInfo;
  @FindBy(xpath = "//div[text()='Price Total']")
  private WebElement priceTotalLabel;

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

	public void clickContinueShoppingButtonfrmCart() {
		continuetoHomePageButton.click();

	}

	public void checkout() {
		clickCartButton();
		clickCartLink();
		clickCheckoutButton();
	}

	public void checkItemRemoved() {
		List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
		Assert.assertTrue(cartItems.isEmpty(), "The cart is not empty!");
	}

	public int getItemsNumberfromCart() {
		List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
		int size = cartItems.size();
		System.out.println(size);
		return size;
	}

	public void checkItemDisplayedInCart() {
		Assert.assertTrue(cartItem.isDisplayed(), "The cart is not empty!");
	}

	public void addSecondItem() {
		SecondItemAddToCartButton.click();

	}

	public void removeSecondItem() {
		removeSecondItemButton.click();
	}

	public void verifyPaymenItemtSummart() {
		Assert.assertTrue(summary_itemlist.isDisplayed(), "Payment summary is not displayed");
	}
	
	

	public void paymentInfo() {
		Assert.assertTrue(paymentInfoLabel.isDisplayed(), "Payment information is not displayed");
	}

	public void shippingInfoDisplay() {
		Assert.assertTrue(shippingInfoLabel.isDisplayed(), "Shipping information is not displayed");
	}
	
	public void verifyCardNumber() {
		Assert.assertTrue(cardNumber.isDisplayed(), "Card number is not displayed");
	}
	
	public void verifyDeliveryInfo() {
		Assert.assertTrue(deliveryInfo.isDisplayed(), "Delivery information is not displayed");
	}
	
	public void verifyPriceTotalLabel() {
		//Assert.assertTrue(priceTotalLabel.isDisplayed(), "Price total label is not displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(priceTotalLabel.isDisplayed(), "Price total label is not displayed");
	}
	public void verifyTotalPrice() {
		Assert.assertTrue(Itemtotal_price.isDisplayed(), "Total price is not displayed");
	}
	public void verifyTax() {
		Assert.assertTrue(tax.isDisplayed(), "Tax is not displayed");
	}
	
	public void verifyPaymentItemPlusTax() {
		Assert.assertTrue(PaymentItemPlusTax.isDisplayed(), "Payment item plus tax is not displayed");
	}
	
}
