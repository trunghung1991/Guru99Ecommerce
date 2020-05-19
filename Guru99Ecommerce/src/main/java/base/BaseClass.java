package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	protected WebDriver driver;

	@BeforeMethod
	public void setupApplication() {
		Reporter.log("====Browser Session Started====", true);

		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nam-Graphic's\\git\\Guru99Ecommerce\\Guru99Ecommerce\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("http://live.demoguru99.com/");

		Reporter.log("====Application Started====", true);
	}

	@AfterMethod		
	public void closeApplication() {
		driver.quit();
		Reporter.log("====Browser Session Ended====", true);
	}

}
