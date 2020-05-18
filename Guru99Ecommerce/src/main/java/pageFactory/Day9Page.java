package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Day9Page extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	WebElement mobileMenu;
	@FindBy(xpath = "//li[@class='item last'][2]/div/div[@class='actions']/button")
	WebElement btnAddToCartIPhone;
	@FindBy(xpath = "//input[@id='coupon_code']")
	WebElement txtCouponCode;
	@FindBy(xpath = "//span[contains(text(),'Apply')]")
	WebElement hlkApplyCouponCode;
	@FindBy(xpath = "//tbody/tr[2]/td[2]/span")
	WebElement lblCouponApplied;
	@FindBy(xpath = "//td[@class='a-right']/strong/span[@class='price']")
	WebElement lblGrandTotal;

	// Constructor
	public Day9Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click on mobile menu
	public void clickMobileMenu() {
		mobileMenu.click();
	}
	
	// Add iPhone to cart
	public void addIPhoneToCart() {
		btnAddToCartIPhone.click();
	}
	
	// Enter coupon code
	public void enterCoupon(String couponCode) {
		txtCouponCode.clear();
		txtCouponCode.sendKeys(couponCode);
		hlkApplyCouponCode.click();
	}
	
	// Get discounted coupon value
	public String getCouponApplied() {
		return lblCouponApplied.getText();
	}
	
	// Get grand total
	public String getGrandTotal() {
		return lblGrandTotal.getText();
	}
}
