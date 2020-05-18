package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Day4Page extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	WebElement mobileMenu;
	@FindBy(xpath = "//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]")
	WebElement btnAddToCompareSony;
	@FindBy(xpath = "//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")
	WebElement btnAddToCompareIphone;
	@FindBy(xpath = "//button[@class='button']//span//span[contains(text(),'Compare')]")
	WebElement btnAddToCompare;
	@FindBy(xpath = "//h1[contains(text(),'Compare Products')]")
	WebElement popupHeader;
	@FindBy(xpath = "//a[contains(text(),'Sony Xperia')]")
	WebElement popupSonyName;
	@FindBy(xpath = "//a[contains(text(),'IPhone')]")
	WebElement popupIphoneName;
	@FindBy(xpath = "//span[contains(text(),'Close Window')]")
	WebElement btnClosePopup;

	// Constructor
	public Day4Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click on mobile menu
	public void clickMobileMenu() {
		mobileMenu.click();
	}

	// Click Add to compare Sony
	public void addToCompareSony() {
		btnAddToCompareSony.click();
	}

	// Click Add to compare iPhone
	public void addToCompareIphone() {
		btnAddToCompareIphone.click();
	}

	// Click Add to compare both
	public void addToCompare() {
		btnAddToCompare.click();
	}

	// Get popup header in compare popup
	public String getPopupHeader() {
		return popupHeader.getText();
	}

	// Get Sony mobile name in compare popup
	public String getSonyNamePopup() {
		return popupSonyName.getText();
	}

	// Get iPhone mobile name in compare popup
	public String getIphoneNamePopup() {
		return popupIphoneName.getText();
	}
	
	// Close compare popup
	public void closePopup() {
		btnClosePopup.click();
	}
}
