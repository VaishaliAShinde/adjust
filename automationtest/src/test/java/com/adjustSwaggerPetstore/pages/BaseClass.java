package com.adjustSwaggerPetstore.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.adjustSwaggerPetstore.utility.BrowserUtility;
import com.adjustSwaggerPetstore.utility.ConfigDataProvider;
import com.adjustSwaggerPetstore.utility.ExcelDataProvider;
import com.adjustSwaggerPetstore.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider testDataFromExcel;
	public ConfigDataProvider configProperties;
	public ExtentReports report;
	
	@BeforeSuite
	public void setupSuite(){
		testDataFromExcel = new ExcelDataProvider();
		configProperties = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Report/"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setup(){
		driver = BrowserUtility.openApplication(driver, configProperties.getBrowser(), configProperties.getAppUrl());
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}
	
	/**
	 This methode will check the test result on runtime. 
	 If test fails then capture the screenshot
	 **/
	@AfterMethod
	public void tearDownMethod(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			Helper.captureScreenshots(driver);
		}
		
	}
	


}
