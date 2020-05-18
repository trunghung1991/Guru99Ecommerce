package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class Day6Page extends BaseClass {
	
	@FindBy(xpath = "//span[@class='label'][contains(text(),'Account')]")
	WebElement hlkAccount;
	@FindBy(xpath = "//a[contains(text(),'Log In')]")
	WebElement hlkLogin;
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtLoginEmail;
	@FindBy(xpath = "//input[@id='pass']")
	WebElement txtLoginPass;
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement btnLogin;
	@FindBy(xpath = "//div[@class='block-content']//a[contains(text(),'My Wishlist')]")
	WebElement hlkMyWishlist;
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	WebElement btnAddToCart;
	@FindBy(xpath = "//button[@title='Proceed to Checkout']")
	WebElement btnProceedToCheckout;

	@FindBy(xpath = "//tbody/tr[2]/td[@class='a-right']/span[@class='price']")
	WebElement cartShippingFlatRate;
	@FindBy(xpath = "//input[@id='s_method_flatrate_flatrate']")
	WebElement rdoCartShippingFlatRate;
	@FindBy(xpath = "//button[@name='do']")
	WebElement btnUpdateCart;

	@FindBy(xpath = "//input[@id='billing:street1']")
	WebElement txtShippingAddress;
	@FindBy(xpath = "//input[@id='billing:city']")
	WebElement txtShippingCity;
	@FindBy(xpath = "//select[@id='billing:region_id']")
	WebElement drpShippingState;
	@FindBy(xpath = "//input[@id='billing:postcode']")
	WebElement txtShippingZip;
	@FindBy(xpath = "//select[@id='billing:country_id']")
	WebElement drpShippingCountry;
	@FindBy(xpath = "//input[@id='billing:telephone']")
	WebElement txtShippingPhone;
	@FindBy(xpath = "//div[@id='billing-buttons-container']/button[@class='button']")
	WebElement btnShippingContinue;
	@FindBy(xpath = "//label/span[@class='price']")
	WebElement shippingFlatRate;
	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']/button[@class='button']")
	WebElement btnFlatRateContinue;
	@FindBy(xpath = "//input[@id='p_method_checkmo']")
	WebElement rdoCheckMoneyOrder;
	@FindBy(xpath = "//div[@id='payment-buttons-container']/button[@class='button']")
	WebElement btnPaymentContinue;
	@FindBy(xpath = "//button[@class='button btn-checkout']")
	WebElement btnPlaceOrder;
	@FindBy(xpath = "//div[@class='page-title']/h1")
	WebElement msgOrderSuccess;
	@FindBy(xpath = "//div[@class='col-main']/p/a")
	WebElement orderID;

	// Constructor
	public Day6Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Click Account link
	public void clickAccount() {
		hlkAccount.click();
	}

	// Click Login link
	public void clickLogin() {
		hlkLogin.click();
	}

	// Login
	public void login(String email, String pass) {
		txtLoginEmail.sendKeys(email);
		txtLoginPass.sendKeys(pass);
		btnLogin.click();
	}

	// Click my wishlist
	public void clickMyWishlist() {
		hlkMyWishlist.click();
	}

	// Click Add to cart
	public void clickAddToCart() {
		btnAddToCart.click();
	}

	// Click Proceed to checkout
	public void proceedToCheckout() {
		btnProceedToCheckout.click();
	}

	// Enter Shipping info
	public void enterShippingInfo(String address, String city, String state, String zip, String country,
			String phoneNo) {
		txtShippingAddress.clear();
		txtShippingAddress.sendKeys(address);
		txtShippingCity.clear();
		txtShippingCity.sendKeys(city);

		Select dropdownState = new Select(drpShippingState);
		dropdownState.selectByValue(state);

		txtShippingZip.clear();
		txtShippingZip.sendKeys(zip);

		Select dropdownCountry = new Select(drpShippingCountry);
		dropdownCountry.selectByValue(country);

		txtShippingPhone.clear();
		txtShippingPhone.sendKeys(phoneNo);
	}

	// Click continue
	public void clickContinue() {
		btnShippingContinue.click();
	}

	// Get Shipping flat rate in checkout
	public String getShippingFlatRate() {
		return shippingFlatRate.getText();
	}

	// Get Shipping flat rate in cart
	public String getCartFlatRate() {
		return cartShippingFlatRate.getText();
	}

	// Select Shipping flat rate radio button in cart
	public void selectCartFlatRate() {
		rdoCartShippingFlatRate.click();
	}

	// Click Update Total in cart
	public void updateCartTotal() {
		btnUpdateCart.click();
	}

	// Click Continue Shipping after navigate back to Checkout
	public void clickContinueShipping2() {
		new Actions(driver).moveToElement(btnShippingContinue).perform();
		btnShippingContinue.click();
	}

	// Click Flat rate continue
	public void clickFlatRateContinue() {
//		new Actions(driver).moveToElement(btnFlatRateContinue).perform();
		btnFlatRateContinue.click();
	}

	// Select Check/Money order radio button
	public void selectCheckMoneyOrder() {
		rdoCheckMoneyOrder.click();
	}

	// Continue payment
	public void clickPaymentContinue() {
		btnPaymentContinue.click();
	}

	// Place order
	public void clickPlaceOrder() {
		btnPlaceOrder.click();
	}

	// Get order success message
	public String getMsgOrderSuccess() {
		return msgOrderSuccess.getText();
	}

	// Get order ID
	public void printOrderID() {
		System.out.println(orderID.getText());
	}
}
