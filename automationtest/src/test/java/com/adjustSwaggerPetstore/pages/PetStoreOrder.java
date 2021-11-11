package com.adjustSwaggerPetstore.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PetStoreOrder extends BaseClass {
	
	WebDriver driver;

	public PetStoreOrder(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath = "//div[@id='operations-store-placeOrder']//button[@class='opblock-summary-control']")
	WebElement placeAnOrderLink;
	
	@FindBy(xpath = "//button[@class='btn try-out__btn']")
	WebElement tryOutBtnForSubmitOrder;
	
	@FindBy(xpath = "//textarea[@class='body-param__text']")
	WebElement newOrderDetails;
	
	@FindBy(xpath = "//button[@class='btn execute opblock-control__btn']")
	WebElement executeBtn;
	
	@FindBy(xpath = "//tr[@class='response']/td[1]")
	WebElement orderSubmitApiResponseCode;

	@FindBy(xpath = "//tr[@class='response']/td[2]//code[@class='language-json']")
	WebElement orderSubmitApiResponseBody;

	@FindBy(xpath = "//button[@class='btn try-out__btn cancel']")
	WebElement cancelBtn;

	public void submitOrder(){
		placeAnOrderLink.click();
		tryOutBtnForSubmitOrder.click();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String expectedDateinResponse = dateFormat.format(date);
		//JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("{"id": 2,"petId": 2,"quantity": 1,"shipDate": "2021-11-11T08:38:05.732Z","status": "placed","complete": true}", newOrderDetails)
		//newOrderDetails.sendKeys("/{"id": 2,"petId": 2,"quantity": 1,"shipDate": "2021-11-11T08:38:05.732Z","status": "placed","complete": true/}");
		//jse.executeScript("document.");
		executeBtn.click();
		Assert.assertEquals(orderSubmitApiResponseCode.getText(), "200");
		Assert.assertEquals(orderSubmitApiResponseBody.getText().contains(expectedDateinResponse), true);
		
		
		cancelBtn.click();
		placeAnOrderLink.click();
		
	}
	
	
}
