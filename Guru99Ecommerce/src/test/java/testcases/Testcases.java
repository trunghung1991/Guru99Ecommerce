package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.util.List;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageFactory.Day10Page;
import pageFactory.Day11Page;
import pageFactory.Day13Page;
import pageFactory.Day1Page;
import pageFactory.Day2Page;
import pageFactory.Day3Page;
import pageFactory.Day4Page;
import pageFactory.Day5Page;
import pageFactory.Day6Page;
import pageFactory.Day7Page;
import pageFactory.Day8Page;
import pageFactory.Day9Page;
import util.EmailUtil;
import util.ExcelUtil;
import util.FileUtil;

public class Testcases extends BaseClass {

	@Test(description = "Day 1", priority = 1, enabled = false)
	public void day1() {
		Day1Page day1Page = new Day1Page(driver);
		day1Page.clickMobileMenu();
		day1Page.selectNameInDropdown();
		Assert.assertTrue(day1Page.verifyAllProductsSortedByName());
	}

	@Test(description = "Day 2", priority = 2, enabled = false)
	public void day2() {
		Day2Page day2Page = new Day2Page(driver);
		day2Page.clickMobileMenu();
		String plpSonyPrice = day2Page.getPLPSonyPrice();
		day2Page.clickPLPSonyThumb();
		String pdpSonyPrice = day2Page.getPDPSonyPrice();
		assertEquals(plpSonyPrice, pdpSonyPrice);
	}

	@Test(description = "Day 3", priority = 3, enabled = false)
	public void day3() {
		Day3Page day3Page = new Day3Page(driver);
		day3Page.clickMobileMenu();
		day3Page.clickAddToCart();
		day3Page.clearTxtCartQuantity();
		day3Page.updateQuantityInCart();
		day3Page.clickUpdateQuantityInCart();
		String errMsgCartOverQty = day3Page.getErrMsgCart();
		day3Page.clickHlkEmptyCart();
		String msgEmptyCart = day3Page.getMsgEmptyCart();

		assertEquals(errMsgCartOverQty, "* The maximum quantity allowed for purchase is 500.");
		assertEquals(msgEmptyCart, "You have no items in your shopping cart.");
	}

	@Test(description = "Day 4", priority = 4, enabled = false)
	public void day4() throws InterruptedException {
		Day4Page day4Page = new Day4Page(driver);
		day4Page.clickMobileMenu();
		day4Page.addToCompareSony();
		day4Page.addToCompareIphone();
		day4Page.addToCompare();

		// Switch to popup
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		Thread.sleep(5000);
		String compareHeader = day4Page.getPopupHeader();
		String sonyName = day4Page.getSonyNamePopup();
		String iPhoneName = day4Page.getIphoneNamePopup();

		assertEquals(compareHeader, "COMPARE PRODUCTS");
		assertEquals(sonyName, "SONY XPERIA");
		assertEquals(iPhoneName, "IPHONE");

		day4Page.closePopup();

		// Switch to main window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

	@Test(description = "Day 5", priority = 5, enabled = false)
	public void day5() {
		Day5Page day5Page = new Day5Page(driver);
		day5Page.clickAccountLink();
		day5Page.clickMyAccountLink();
		day5Page.clickCreateAccount();
		day5Page.enterRegistrationDetails("Hung", "Nguyen", "hung.nguyen5@email.com", "123456", "123456");
		day5Page.clickRegister();

		String msgRegisterSuccess = day5Page.getMsgRegisterSuccess();
		assertEquals(msgRegisterSuccess, "Thank you for registering with Main Website Store.");

		day5Page.clickTVMenu();
		day5Page.addToWishlist();
		day5Page.clickShareWishlist();
		day5Page.enterShareWishlistDetails("share.wishlist@email.com", "Wishlist should be shared successfully");
		day5Page.clickShareWishlist();
		String msgShareWishlistSuccess = day5Page.getMsgShareWishlistSuccess();
		assertEquals(msgShareWishlistSuccess, "Your Wishlist has been shared.");
	}

	@Test(description = "Day 6", priority = 6, enabled = false)
	public void day6() throws InterruptedException {
		Day6Page day6Page = new Day6Page(driver);
		day6Page.clickAccount();
		day6Page.clickLogin();
		day6Page.login("hung.nguyen5@email.com", "123456");
		day6Page.clickMyWishlist();
		day6Page.clickAddToCart();
		day6Page.proceedToCheckout();

		day6Page.enterShippingInfo("ABC", "New York", "43", "542896", "US", "12345678");
		day6Page.clickContinue();

		Thread.sleep(5000);
		String shippingFlatRate = day6Page.getShippingFlatRate();
		driver.navigate().back();

		Thread.sleep(5000);
		day6Page.selectCartFlatRate();
		day6Page.updateCartTotal();
		String cartShippingFlatRate = day6Page.getCartFlatRate();
		assertEquals(shippingFlatRate, "$5.00");
		assertEquals(cartShippingFlatRate, "$5.00");

		day6Page.proceedToCheckout();
		day6Page.clickContinueShipping2();
		Thread.sleep(5000);
		day6Page.clickFlatRateContinue();
		Thread.sleep(5000);
		day6Page.selectCheckMoneyOrder();
		Thread.sleep(5000);
		day6Page.clickPaymentContinue();
		Thread.sleep(5000);
		day6Page.clickPlaceOrder();

		Thread.sleep(5000);
		String msgOrderSuccess = day6Page.getMsgOrderSuccess();
		assertEquals(msgOrderSuccess, "YOUR ORDER HAS BEEN RECEIVED.");
		day6Page.printOrderID();
	}

	@Test(description = "Day 7", priority = 7, enabled = false)
	public void day7() throws InterruptedException, AWTException {
		Day7Page day7Page = new Day7Page(driver);
		day7Page.clickAccount();
		day7Page.clickLogin();
		day7Page.login("hung.nguyen2@email.com", "123456");

		Thread.sleep(2000);
		day7Page.clickMyOrders();
		Thread.sleep(2000);
		day7Page.clickViewOrder();
		Thread.sleep(2000);
		String orderHeader = day7Page.getOrderHeader();
		try {
			assertEquals(orderHeader, "ORDER #100011915 - PENDING");
		} catch (Exception e) {
			System.out.println("Can't find header text");
		}
		Thread.sleep(2000);
		day7Page.clickPrintOrder();
		Thread.sleep(2000);

		// Print order in Chrome print popup
		day7Page.printOrder();
		// Switch to popup
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		// Save pdf file in Save As dialog
		day7Page.printOrder();
		Thread.sleep(2000);
		Assert.assertTrue(FileUtil.isFileDownloaded("C:/Users/hung.nguyen/Downloads/", "Print Order # 100011915.pdf"));
	}

	@Test(description = "Day 8", priority = 8, enabled = false)
	public void day8() throws InterruptedException {
		Day8Page day8Page = new Day8Page(driver);
		day8Page.clickAccount();
		day8Page.clickLogin();
		day8Page.login("hung.nguyen2@email.com", "123456");
		day8Page.clickReOrder();
		day8Page.updateQty("10");

		Thread.sleep(2000);
		String txtGrandTotal = day8Page.getGrandTotal();
		try {
			assertEquals(txtGrandTotal, "$6,150.00");
		} catch (Exception e) {
			System.out.println("Grand Total is not the same");
		}
		
		day8Page.checkout();
		Thread.sleep(2000);
		day8Page.clickBillingCont();
		Thread.sleep(2000);
		day8Page.clickShippingCont();
		Thread.sleep(2000);
		day8Page.clickPaymentMethodCont();
		Thread.sleep(2000);
		day8Page.placeOrder();
		Thread.sleep(2000);
		String orderID = day8Page.getOrderID();
		try {
			assertTrue(orderID != null);
		} catch (Exception e) {
			System.out.println("Can't get order ID");
		}
	}
	
	@Test(description = "Day 9", priority = 9, enabled = false)
	public void day9() throws InterruptedException {
		Day9Page day9Page = new Day9Page(driver);
		day9Page.clickMobileMenu();
		day9Page.addIPhoneToCart();
		day9Page.enterCoupon("GURU50");
		
		Thread.sleep(2000);
		String discountedValue = day9Page.getCouponApplied();
		String grandTotal = day9Page.getGrandTotal();
		try {
			assertEquals(discountedValue, "-$25.00");
			assertEquals(grandTotal, "$475.00");
		} catch (Exception e) {
			System.out.println("Coupon is not discounted correctly");
		}
	}
	
	@Test(description = "Day 10", priority = 10, enabled = false)
	public void day10() throws MessagingException, InterruptedException {
		Day10Page day10Page = new Day10Page(driver);
		day10Page.adminLogin("user01", "guru99com");
		day10Page.closePopup();
		day10Page.clickMenuOrders();
		day10Page.exportCSV();
		Thread.sleep(7000);
		FileUtil.readCSV("C:\\Users\\hung.nguyen\\Downloads", "orders.csv");
		EmailUtil.sendMail();
	}
	
	@Test(description = "Day 11", priority = 11)
	public void day11() throws MessagingException, InterruptedException {
		Day11Page day11Page = new Day11Page(driver);
		day11Page.adminLogin("user01", "guru99com");
		Thread.sleep(2000);
		day11Page.closePopup();
		day11Page.clickMenuOrders();
		Thread.sleep(2000);
		day11Page.selectCancelledStatus();
		day11Page.clickSearch();
		Thread.sleep(2000);
		day11Page.selectFirstOrder();
		day11Page.selectPrintInvoices();
		day11Page.clickSubmit();
		Thread.sleep(2000);
		assertEquals(day11Page.getMsgErrPrintInvoice(), "There are no printable documents related to selected orders.");
		
		Thread.sleep(2000);
		day11Page.selectCompleteStatus();
		Thread.sleep(2000);
		day11Page.clickSearch();
		Thread.sleep(2000);
		day11Page.selectFirstOrder();
		day11Page.selectPrintInvoices();
		day11Page.clickSubmit();
		String expectedPDF = FileUtil.appendDateTimeToPDF();
		Thread.sleep(10000);
		Assert.assertTrue(FileUtil.isFileDownloaded("C:\\Users\\Nam-Graphic's\\Downloads", expectedPDF));
	}
	
	@Test(description = "Day 13", priority = 13, enabled = false)
	public void day13() throws InterruptedException {
		Day13Page day13Page = new Day13Page(driver);
		day13Page.adminLogin("user01", "guru99com");
		day13Page.closePopup();
		day13Page.clickMenuInvoice();
		Thread.sleep(2000);
		
		List<String> actualInvoiceDate = day13Page.getInvoiceDate();
		List<String> expectInvoiceDate = ExcelUtil.ReadExcel("C:\\Users\\Nam-Graphic's\\Desktop\\TestData.xlsx");
		System.out.println(actualInvoiceDate);
		System.out.println(expectInvoiceDate);
		
		assertTrue(actualInvoiceDate.equals(expectInvoiceDate));
	}
}
