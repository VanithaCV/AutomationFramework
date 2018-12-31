package com.crossover.e2e;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends TestBase {
	TestBase tb;
	WebDriver driver;
	private Properties properties = new Properties();

	@FindBy(name = "to")
	public WebElement toBox;

	@FindBy(name = "subjectbox")
	public WebElement subjectBox;

	@FindBy(xpath = "//*[@aria-label='Message Body' and @role='textbox']")
	public WebElement messageBody;

	@FindBy(xpath = "//*[@role='button' and (.)='Compose']")
	public WebElement composeElement;

	@FindBy(xpath = "//*[@role='button' and text()='Send']")
	public WebElement sendButton;

	@FindBy(xpath = "(//*[@class='zF'][@name='me'])[last()]")
	public WebElement openMail;

	@FindBy(xpath = "//*[@class='hP']")
	public WebElement mailSubject;

	@FindBy(xpath = "//*[@class='ii gt']/..")
	public WebElement inboxMessageBody;

	public InboxPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		properties.load(new FileReader(new File("test.properties")));
	}

	public InboxPage composeMail() throws Exception {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		composeElement.click();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		toBox.clear();
		toBox.sendKeys(String.format("%s@gmail.com", properties.getProperty("username")));
		subjectBox.sendKeys(properties.getProperty("emailSubjects"));
		messageBody.sendKeys(properties.getProperty("messageBody"));
		sendButton.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		openMail.click();

		return new InboxPage(driver);
	}
}
