package com.crossover.e2e;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	TestBase tb = new TestBase();
	WebDriver driver;
	private Properties properties = new Properties();
	URLBuilder url = new URLBuilder();
	AppConstants ac = new AppConstants(driver);
	
	@FindBy(id = "identifierId")
	public WebElement userElement;
	
	@FindBy(id = "identifierNext")
	public WebElement nextButton;
	
	@FindBy(name = "password")
	public WebElement passwordElement;
	
	@FindBy(id = "passwordNext")
	public WebElement passwordNext;

	public loginPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public InboxPage userLogin() throws Exception {
		driver.get(url.loginPageURL);
		properties.load(new FileReader(new File("test.properties")));
		userElement.sendKeys(properties.getProperty("username"));
		nextButton.click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		passwordElement.sendKeys(properties.getProperty("password"));
		passwordNext.click();
		return new InboxPage(driver);
	}
}
