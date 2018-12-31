package com.crossover.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeBrowser {

	public WebDriver getChromeDriver() {
		
		if(System.getProperty("os.name").contains("Window")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Prakat-L-045\\eclipse-workspace\\Saurabh\\SampleProject\\driver\\chromedriver.exe");
			return new ChromeDriver();
		}	
		return null;
	}
}
