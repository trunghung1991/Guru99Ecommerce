package pageFactory;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class Day1Page extends BaseClass {
	
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	WebElement mobileMenu;
	@FindBy(xpath = "//div[@class='sort-by']/select")
	WebElement testDropdown;
	@FindBy(xpath = "//h2/a[@title]")
	List<WebElement> productWebElement;

	// Constructor
	public Day1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Click on mobile menu
	public void clickMobileMenu() {
		mobileMenu.click();
	}

	// Select Name in dropdown
	public void selectNameInDropdown() {
		Select dropdown = new Select(testDropdown);
		dropdown.selectByIndex(1);
	}

	// Verify all products are sorted by name v2
	public boolean verifyAllProductsSortedByName() {
		List<String> productName = new LinkedList<String>();
		for (int i = 0; i < productWebElement.size(); i++) {
			String s = productWebElement.get(i).getText();
			productName.add(s);
			System.out.println(productName + "\n");
		}
		return checkAlphabeticalOrder(productName);
//		System.out.println(isAlphabeticalOrder);
	}

	/* Verify all products are sorted by name */
	// Create a LinkedList instead of ArrayList because it preserves insertion order
//		List<WebElement> productWebElement = new LinkedList<WebElement>();
//
	// Store the products (Web Elements) into the LinkedList
//		productWebElement = driver.findElements(By.xpath("//img[contains(@id, 'product-collection-image')]"));
//
	// Create another LinkedList of type String to store image title
//		List<String> productName = new LinkedList<String>();
//
	// Loop through all the elements of productWebElement list, get it title and and
	// store in the productName list
//		for (int i = 0; i < productWebElement.size(); i++) {
//			String s = productWebElement.get(i).getAttribute("alt");
//			productName.add(s);
//			System.out.println(productName+"\n");
//		}
//
	// Send the list to checkAlphabeticalOrder method to check if elements in the
	// list are in alphabetical order
//		boolean isAlphabeticalOrder = checkAlphabeticalOrder(productName);
//		System.out.println(isAlphabeticalOrder);

	private static boolean checkAlphabeticalOrder(List<String> productName) {
		String previous = ""; // empty string

		for (String current : productName) {
			if (current.compareTo(previous) < 0)
				return false;
			previous = current;
		}
		return true;
	}
}
