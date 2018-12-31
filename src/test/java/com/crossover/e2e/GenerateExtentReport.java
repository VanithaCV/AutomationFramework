package com.crossover.e2e;

import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateExtentReport {

	ExtentReports extent;
	ExtentTest test;
	
	
	@BeforeTest
	public void startReport() {
		extent =  new ExtentReports(System.getProperty("user.dir") +"/test-output/MyOwnReport.html", true);
		extent.addSystemInfo("Host Name","LocalHost");
		extent.addSystemInfo("Environment","QA");
		extent.addSystemInfo("User Name","Saurabh");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		extent.endTest(test);
	}
	
	
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
}
