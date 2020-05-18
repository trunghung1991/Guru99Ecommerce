package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Day2Page extends BaseClass {
	
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	WebElement mobileMenu;
	@FindBy(xpath = "//span[contains(text(),'$100.00')]")
	WebElement plpSonyPrice;
	@FindBy(xpath = "//img[@id='product-collection-image-1']")
	WebElement plpSonyThumb;
	@FindBy(xpath = "//span[@class='price']")
	WebElement pdpSonyPrice;

	// Constructor
	public Day2Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Click on mobile menu
	public void clickMobileMenu() {
		mobileMenu.click();
	}

	// Get Sony Xperia price in PLP
	public String getPLPSonyPrice() {
		return plpSonyPrice.getText();
	}
	
	// Go to Sony Xperia PDP
	public void clickPLPSonyThumb() {
		plpSonyThumb.click();
	}
	
	// Get Sony Xperia price in PDP
	public String getPDPSonyPrice() {
		return pdpSonyPrice.getText();
	}
}
