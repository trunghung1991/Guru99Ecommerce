package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Day5Page extends BaseClass {

	@FindBy(xpath = "//span[@class='label'][contains(text(),'Account')]")
	WebElement hlkAccount;
	@FindBy(xpath = "//div[@id='header-account']//a[contains(text(),'My Account')]")
	WebElement hlkMyAccount;
	@FindBy(xpath = "//span[contains(text(),'Create an Account')]")
	WebElement btnCreateAccount;
	
	@FindBy (xpath = "//input[@id='firstname']")
	WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement txtLastName;
	@FindBy(xpath = "//input[@id='email_address']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@id='confirmation']")
	WebElement txtConfirmPassword;
	@FindBy(xpath = "//span[contains(text(),'Register')]")
	WebElement btnRegister;
	@FindBy(xpath = "//li[@class='success-msg']//ul//li/span")
	WebElement msgRegisterSuccess;
	
	@FindBy(xpath = "//a[contains(text(),'TV')]")
	WebElement tvMenu;
	@FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")
	WebElement hlkAddToWishlist;
	@FindBy(xpath = "//span[contains(text(),'Share Wishlist')]")
	WebElement btnShareWishlist;
	@FindBy(xpath = "//textarea[@id='email_address']")
	WebElement txtAreaSharedEmail;
	@FindBy(xpath = "//textarea[@id='message']")
	WebElement txtAreaMsg;
	@FindBy(xpath = "//li[@class='success-msg']//ul//li/span")
	WebElement msgShareWishlistSuccess;

	// Constructor
	public Day5Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click Account link
	public void clickAccountLink() {
		hlkAccount.click();
	}
	
	// Click My Account link 
	public void clickMyAccountLink() {
		hlkMyAccount.click();
	}
	
	// Click Create Account link
	public void clickCreateAccount() {
		btnCreateAccount.click();
	}
	
	// Enter registration details
	public void enterRegistrationDetails(String firstName, String lastName, String email, String password, String confirmPassword) {
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		txtConfirmPassword.sendKeys(confirmPassword);
	}
	
	// Click Register button
	public void clickRegister() {
		btnRegister.click();
	}
	
	// Get message Register successfully
	public String getMsgRegisterSuccess() {
		return msgRegisterSuccess.getText();
	}
	
	// Click TV menu
	public void clickTVMenu() {
		tvMenu.click();
	}
	
	// Add product = LG LCD to wish list
	public void addToWishlist() {
		hlkAddToWishlist.click();
	}
	
	// Click share wish list
	public void clickShareWishlist() {
		btnShareWishlist.click();
	}
	
	// Enter email and message in share wish list screen
	public void enterShareWishlistDetails(String email, String msg) {
		txtAreaSharedEmail.sendKeys(email);
		txtAreaMsg.sendKeys(msg);
	}
	
	// Get share wish list successfully message
	public String getMsgShareWishlistSuccess() {
		return msgShareWishlistSuccess.getText();
	}
}
