package com.crossover.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class URLBuilder extends GenerateExtentReport{
	public String loginPageURL;
	WebDriver driver;

	public URLBuilder() {
		PageFactory.initElements(driver, this);
		loginPageURL = "https://mail.google.com/";
	}

	public String getPageURL(String url) {
		return this.loginPageURL = url;
	}
}
