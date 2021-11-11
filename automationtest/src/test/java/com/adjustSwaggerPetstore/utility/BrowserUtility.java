package com.adjustSwaggerPetstore.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtility {
	
public static WebDriver openApplication(WebDriver driver, String browser, String appUrl){
		
		if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser=="Firefox"){
			System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser=="IE"){
			System.setProperty("webdriver.chrome.driver", "./IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else{
			System.out.println("We do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver){
		
		driver.close();
		
	}


}
