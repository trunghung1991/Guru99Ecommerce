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

public class Day10Page extends BaseClass {

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
	@FindBy(xpath = "//select[@id='sales_order_grid_export']")
	WebElement drpExportTo;
	@FindBy(xpath = "//button[@title='Export']")
	WebElement btnExport;

	// Constructor
	public Day10Page(WebDriver driver) {
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

	// Select CSV in Export To dropdown
	public void exportCSV() {
		Select csv = new Select(drpExportTo);
		csv.selectByIndex(0);
		btnExport.click();
	}

	
}
