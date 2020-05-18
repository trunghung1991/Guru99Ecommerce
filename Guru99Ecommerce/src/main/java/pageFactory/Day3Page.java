package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Day3Page extends BaseClass {
	
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	WebElement mobileMenu;
	@FindBy(xpath = "//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]")
	WebElement btnPLPSonyAddToCart;
	@FindBy(xpath = "//td[@class='product-cart-actions']/input")
	WebElement txtCartQuantity;
	@FindBy(xpath = "//td[@class='product-cart-actions']//button[@name='update_cart_action']//span//span[contains(text(),'Update')]")
	WebElement btnCartUpdate;
	@FindBy(xpath = "//p[@class='item-msg error']")
	WebElement errMsgCartOverQuantity;
	@FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
	WebElement hlkEmptyCart;
	@FindBy(xpath = "//div[@class='cart-empty']//p[contains(text(),'You have no items in your shopping cart.')]")
	WebElement msgEmptyCart;

	// Constructor
	public Day3Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Click on mobile menu
	public void clickMobileMenu() {
		mobileMenu.click();
	}

	// Click add to cart Sony Xperia mobile in PDP
	public void clickAddToCart() {
		btnPLPSonyAddToCart.click();
	}
	
	// Clear update quantity textbox
	public void clearTxtCartQuantity() {
		txtCartQuantity.clear();
	}
	
	// Update quantity to 1000
	public void updateQuantityInCart() {
		txtCartQuantity.sendKeys("1000");
	}
	
	// Click update quantity button in cart
	public void clickUpdateQuantityInCart() {
		btnCartUpdate.click();
	}
	
	// Get error message when updating quantity of Sony Xperia in cart to 1000
	public String getErrMsgCart() {
		return errMsgCartOverQuantity.getText();
	}
	
	// Click Empty Cart link
	public void clickHlkEmptyCart() {
		hlkEmptyCart.click();
	}
	
	// Get message empty cart
	public String getMsgEmptyCart() {
		return msgEmptyCart.getText();
	}
}
