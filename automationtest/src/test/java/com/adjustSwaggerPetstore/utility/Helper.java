package com.adjustSwaggerPetstore.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static void captureScreenshots(WebDriver driver){
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(src, new File("./Screenshots/LoginPage/Login_"+ getCurrentDateTime() +".png"));
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot "+e.getMessage());
		}
	}
	
	public static String getCurrentDateTime(){
		DateFormat customeDateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customeDateFormat.format(currentDate);
	}

}
