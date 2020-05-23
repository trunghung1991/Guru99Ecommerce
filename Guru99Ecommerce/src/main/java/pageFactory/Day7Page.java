package pageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Day7Page extends BaseClass {

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
	@FindBy(xpath = "//a[contains(text(),'My Orders')]")
	WebElement hlkMyOrders;
	@FindBy(xpath = "//a[contains(text(),'View Order')]")
	WebElement hlkViewOrder;
	@FindBy(xpath = "//div[@class='page-title title-buttons']/h1")
	WebElement lblOrderHeader;
	@FindBy(xpath = "//a[@class='link-print']")
	WebElement hlkPrintOrder;

	// Constructor
	public Day7Page(WebDriver driver) {
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

	// Click My orders
	public void clickMyOrders() {
		hlkMyOrders.click();
	}

	// Click View order
	public void clickViewOrder() {
		hlkViewOrder.click();
	}

	// Get order header
	public String getOrderHeader() {
		return lblOrderHeader.getText();
	}

	// Click Print order
	public void clickPrintOrder() {
		hlkPrintOrder.click();
	}

	// Print order save as pdf
	public void printOrder() throws AWTException {
		Robot r = new Robot();
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
