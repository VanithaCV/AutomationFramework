package com.crossover.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase extends URLBuilder {

	public WebDriver driver;

	public WebDriver getBrowserObject(BrowserType bType) throws Exception {
		try {

			switch (bType) {

			case Chrome:
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Prakat-L-045\\eclipse-workspace\\Saurabh\\SampleProject\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
				return driver;

			case Firefox:
				System.setProperty("webdriver.gecko.driver", "/src/main/resources/drivers/chromedriver");
				driver = new FirefoxDriver();
				return driver;
			default:
				throw new Exception(" Driver Not Found : ");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public WebDriver setUpDriver(BrowserType bType) throws Exception {
		driver = getBrowserObject(bType);
		driver.manage().window().maximize();
		return driver;
	}
}
