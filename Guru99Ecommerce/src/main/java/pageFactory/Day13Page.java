package pageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Day13Page extends BaseClass {

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
	@FindBy(xpath = "//span[contains(text(),'Invoices')]")
	WebElement mnInvoice;

	@FindBy(xpath = "//table[@id='sales_invoice_grid_table']/tbody/tr/td[3]")
	List<WebElement> colInvoiceDate;

	// Constructor
	public Day13Page(WebDriver driver) {
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

	// Click Invoice menu
	public void clickMenuInvoice() {
		Actions action = new Actions(driver);
		action.moveToElement(mnSale).perform();
		mnInvoice.click();
	}

	// Get value of all Invoice date
	public void getInvoiceDate() {
		List<String> date = new ArrayList<String>();
		for (WebElement tdElement : colInvoiceDate) {
			date.add(tdElement.getText());
		}
		System.out.println(date);
	}
}
