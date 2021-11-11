package com.adjustSwaggerPetstore.testcases;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.adjustSwaggerPetstore.pages.BaseClass;
import com.adjustSwaggerPetstore.pages.LandingPage;
import com.adjustSwaggerPetstore.pages.PetDetailsPage;
import com.adjustSwaggerPetstore.pages.PetStoreOrder;
import com.adjustSwaggerPetstore.utility.ExcelDataProvider;

public class LaunchTest extends BaseClass {
	
	@Test
	public void launchUrlTest(){
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);	
		landingPage.verifyPageTitle();
		
	}
	
	@Test
	public void getPetDetailsByStatus(){
		PetDetailsPage petDetailsPage = PageFactory.initElements(driver, PetDetailsPage.class);
		petDetailsPage.verifyPetDetailsUsingStatus("available");
	}
	
	@Test
	public void submitPetOrder(){
		PetStoreOrder petStoreOrder = PageFactory.initElements(driver, PetStoreOrder.class);
		petStoreOrder.submitOrder();
	}
	
}
