package com.crossover.e2e;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomReport.class)
public class GMailTest extends TestBase {

	WebDriver driver;
	loginPage login;
	TestBase tb;
	InboxPage inboxPage;
	BrowserType chromeBrowser;
	private Properties properties;
	ExtentTest test;
	ITestResult result;
	
	@BeforeTest
	public void setUp() throws Exception {
		tb = new TestBase();
		properties = new Properties();
		driver = tb.setUpDriver(chromeBrowser.Chrome);
		properties.load(new FileReader(new File("test.properties")));
	}

	/*
	 * @AfterTest public void tearDown() throws Exception { driver.quit(); }
	 */

	@Test
	public void testSendEmail() throws Exception {
		login = new loginPage(driver);
		login.userLogin();
		inboxPage = new InboxPage(driver);
		inboxPage.composeMail();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String inboxPageText = inboxPage.mailSubject.getText();
		String inboxMessageBodyText = inboxPage.inboxMessageBody.getText();

		if (inboxPageText.equalsIgnoreCase(properties.getProperty("emailSubjects"))
				&& inboxMessageBodyText.equalsIgnoreCase(properties.getProperty("messageBody"))) {
			test = extent.startTest("ComposeMailTestPassed");
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, "TestCase passed successfully");
		} else {
			test.log(LogStatus.FAIL, "TestCase FAILED !!!");
			Assert.assertFalse(true);
		}
	}
}