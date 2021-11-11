package com.adjustSwaggerPetstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PetDetailsPage extends BaseClass {
	
	WebDriver driver;

	public PetDetailsPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	 
	@FindBy(xpath = "//a[.='pet']") 
	WebElement petDetailsLink;
	
	@FindBy(xpath = "//div[@id='operations-pet-findPetsByStatus']//button[@class='opblock-summary-control']")
	WebElement getDetailsButton;
	
	@FindBy(xpath = "//td[@class='parameters-col_description']//select")
	WebElement petStatus;
	
	@FindBy(xpath = "//button[@class='btn try-out__btn']")
	WebElement tryOutBtnForPetDetails;
	
	@FindBy(xpath = "//button[@class='btn execute opblock-control__btn']")
	WebElement executeBtn;
	
	
	@FindBy(xpath = "//tr[@class='response']/td[1]")
	WebElement petDetailsApiResponseCode;

	@FindBy(xpath = "//tr[@class='response']/td[2]")
	WebElement petDetailsApiResponseDescription;

	@FindBy(xpath = "//button[@class='btn try-out__btn cancel']")
	WebElement cancelBtn;
	
	public void verifyPetDetailsUsingStatus(String status){
	
		getDetailsButton.click();
		tryOutBtnForPetDetails.click();
		
		Select selectPettStatus = new Select(petStatus);
		selectPettStatus.selectByVisibleText(status);
		executeBtn.click();
		
		switch(status){
		case "pending":
			Assert.assertEquals(petDetailsApiResponseCode.getText(), "200");
			Assert.assertEquals(petDetailsApiResponseDescription.getText().contains("pending"), true);
		break;
		
		case "available":
			Assert.assertEquals(petDetailsApiResponseCode.getText(), "200");
			Assert.assertEquals(petDetailsApiResponseDescription.getText().contains("available"), true);
		break;
		
		case "sold":
			Assert.assertEquals(petDetailsApiResponseCode.getText(), "200");
			Assert.assertEquals(petDetailsApiResponseDescription.getText().contains("sold"), true);
		break;
		
		default:
			System.out.println("Invalid Status");
			
		}
		cancelBtn.click();
		getDetailsButton.click();
		
	}
	

}
