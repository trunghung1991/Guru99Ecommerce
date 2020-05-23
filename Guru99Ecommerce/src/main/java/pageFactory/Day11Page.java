package pageFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class Day11Page extends BaseClass {

	@FindBy(xpath = "//input[@id='username']")
	WebElement txtUsername;
	@FindBy(xpath = "//input[@id='login']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@class='form-button']")
	WebElement btnLogin;
	@FindBy(xpath = "//span[contains(text(),'close')]")
	WebElement btnClosePopup;
	@FindBy(xpath = "//span[contains(text(),'Sales')]")
	WebElement mnSale;
	@FindBy(xpath = "//span[contains(text(),'Orders')]")
	WebElement mnOrder;
	@FindBy(xpath = "//select[@id='sales_order_grid_filter_status']")
	WebElement drpStatus;
	@FindBy(xpath = "//span[contains(text(),'Search')]")
	WebElement btnSearch;
	@FindBy(xpath = "//tbody/tr[1]/td/input[@name='order_ids']")
	WebElement chkFirstOrder;
	@FindBy(xpath = "//select[@id='sales_order_grid_massaction-select']")
	WebElement drpActions;
	@FindBy(xpath = "//button[@title='Submit']")
	WebElement btnSubmit;
	@FindBy(xpath = "//li[@class='error-msg']/ul/li/span")
	WebElement msgPrintError;

	// Constructor
	public Day11Page(WebDriver driver) {
		this.driver = driver;
		driver.get("http://live.demoguru99.com/index.php/backendlogin/");
		PageFactory.initElements(driver, this);
	}

	// Login Admin panel
	public void adminLogin(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		btnLogin.click();
	}

	// Close popup after login
	public void closePopup() {
		btnClosePopup.click();
	}

	// Click Order menu
	public void clickMenuOrders() {
		Actions action = new Actions(driver);
		action.moveToElement(mnSale).perform();
		mnOrder.click();
	}
	
	// Select Cancelled status
	public void selectCancelledStatus() {
		Select select = new Select(drpStatus);
		select.selectByValue("canceled");
	}
	
	// Click Search button
	public void clickSearch() {
		btnSearch.click();
	}
	
	// Select checkbox of first order
	public void selectFirstOrder() {
		chkFirstOrder.click();
	}
	
	// Select Action Print invoices
	public void selectPrintInvoices() {
		Select select = new Select(drpActions);
		select.selectByValue("pdfinvoices_order");
	}
	
	// Click Submit button
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	// Get print invoices error message
	public String getMsgErrPrintInvoice() {
		return msgPrintError.getText();
	}
	
	// Select Complete status
	public void selectCompleteStatus() {
		Select select = new Select(drpStatus);
		select.selectByValue("complete");
	}
}
