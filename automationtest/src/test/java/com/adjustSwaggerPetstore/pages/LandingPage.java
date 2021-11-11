package com.adjustSwaggerPetstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LandingPage extends BaseClass {
	
	WebDriver driver;
	
	public LandingPage(WebDriver ldriver){
		this.driver = ldriver;		
	}
	
	public void verifyPageTitle(){
		
		Assert.assertEquals("Swagger UI", driver.getTitle());
		
	}
	
	

}
