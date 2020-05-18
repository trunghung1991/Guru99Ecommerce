package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Day8Page extends BaseClass {

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
	@FindBy(xpath = "//a[@class='link-reorder']")
	WebElement btnReorder;
	@FindBy(xpath = "//input[@title='Qty']")
	WebElement txtQty;
	@FindBy(xpath = "//td[@class='product-cart-actions']/button")
	WebElement btnUpdateQty;
	@FindBy(xpath = "//td[@class='a-right']/strong/span[@class='price']")
	WebElement lblGrandTotal;
	@FindBy(xpath = "//ul[@class='checkout-types top']/li/button[@title='Proceed to Checkout']")
	WebElement btnProceedToCheckout;
	@FindBy(xpath = "//div[@id='billing-buttons-container']/button[@title='Continue']")
	WebElement btnBillingCont;
	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']/button")
	WebElement btnShippingCont;
	@FindBy(xpath = "//input[@id='p_method_checkmo']")
	WebElement rdoCheckMoney;
	@FindBy(xpath = "//div[@id='payment-buttons-container']/button")
	WebElement btnPaymentCont;
	@FindBy(xpath = "//button[@class='button btn-checkout']")
	WebElement btnPlaceOrder;
	@FindBy(xpath = "//p[contains(text(),'Your order # is: ')]/a")
	WebElement lblOrderID;

	// Constructor
	public Day8Page(WebDriver driver) {
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

	// Click Reorder
	public void clickReOrder() {
		btnReorder.click();
	}

	// Update quantity
	public void updateQty(String quantity) {
		txtQty.clear();
		txtQty.sendKeys(quantity);
		btnUpdateQty.click();
	}

	// Get Grand total
	public String getGrandTotal() {
		return lblGrandTotal.getText();
	}

	// Proceed to checkout
	public void checkout() {
		btnProceedToCheckout.click();
	}

	// Click Billing continue
	public void clickBillingCont() {
		btnBillingCont.click();
	}

	// Click Billing continue
	public void clickShippingCont() {
		btnShippingCont.click();
	}

	// Click Payment method continue
	public void clickPaymentMethodCont() {
		rdoCheckMoney.click();
		btnPaymentCont.click();
	}
	
	// Click Place order
	public void placeOrder() {
		btnPlaceOrder.click();
	}
	
	// Get generated order ID
	public String getOrderID() {
		return lblOrderID.getText();
	}
}
