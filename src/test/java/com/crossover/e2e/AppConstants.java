package com.crossover.e2e;

import org.openqa.selenium.WebDriver;

public class AppConstants {

	WebDriver driver;
	String loginPageURL = "https://mail.google.com/";
	public  AppConstants(WebDriver driver) {
		this.driver = driver;
	}

	
}
