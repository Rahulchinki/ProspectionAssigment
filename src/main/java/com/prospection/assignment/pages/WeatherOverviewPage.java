package com.prospection.assignment.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prospection.base.TestBase;

public class WeatherOverviewPage {
	

	WebDriver driver;
	
	@FindBy(id="location-search-box")
	WebElement locationSearchInput;
	
	
	
	@FindBy(xpath="//input[@value='Search']")
	WebElement btnSearch;
	
	@FindBy(xpath="//a[contains(text(),'Map View')]")
	WebElement mapViewLink;
	
	@FindBy(xpath="//ul[class='search-suggest']")
	WebElement suggestedSearchList;
	
	@FindBy(tagName="h1")
	
	WebElement WeatherOverviewHeading;
	
	@FindBy(xpath="//table[@summary='Rainfall forecast for the next 18 hours']")
	WebElement RainSummaryEighteenHours;
	
	@FindBy(xpath="//h2/span")
	WebElement currentDay;
	

	@FindBy(xpath="//ul[@class='search-suggest']/li")
	List <WebElement> locationsList;
	

	
	
	public WeatherOverviewPage(WebDriver driver) {
	this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchLocationViaPostCode(String postCode,String subUrb) {
		locationSearchInput.click();
		locationSearchInput.sendKeys(postCode);
		selectLocation( postCode, subUrb);
	}
	
	
	
	public void searchLocationViaSuburbe(String subUrb,String postCode) {
		locationSearchInput.click();
		locationSearchInput.sendKeys(subUrb);
		selectLocation( postCode, subUrb);
	}
	private void selectLocation(String postCode, String subUrb)  {
		try {
		Thread.sleep(4000);
		
		 for(WebElement loc : locationsList) {
			 if(loc.getText().contains(subUrb) && loc.getText().contains(postCode)) {
				 loc.click();
				 break;
			 }
		 }
		}catch(Exception e) {e.printStackTrace();}
			 
		 }
		
	


	public void searchLocationViaSuburbName(String subUrb,String postCode) {
		locationSearchInput.clear();
		locationSearchInput.click();
		locationSearchInput.sendKeys(subUrb);
		selectLocation( postCode, subUrb);
	}


	public String getHeadingText() {
		return WeatherOverviewHeading.getText();
	
	}


	public void clickMapView() {
		mapViewLink.click();
		// TODO Auto-generated method stub
		
	}

//public String verifyRainForcastSummary() {
//		String error=null;
//		Date date = new Date();
//
//		SimpleDateFormat DateCurrent = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
//		
//		String stringDate1 = DateCurrent.format(date);
//		String CurrentDay=currentDay.getText();
//		String eighteenhourRainForecast=RainSummaryEighteenHours.getAttribute("summary");
//		if(!(CurrentDay.equalsIgnoreCase(stringDate1) ))
//		{
//			return "Current Day details is missing";
//		}
//		
//		if(! eighteenhourRainForecast.contains("Rainfall forecast for the next 18 hours"))
//		{
//			return "Rainfall forecast for the next 18 hours details are missing";
//		}
//		
//		
//		//verifying details for rest of the days
//		
//		
//		//Verifying that Rsin fall summary for subsequent 6 days are shown
//		//First verify that current Day is shown for the very first forecast section
//		
//	/*	Date date = new Date();
//
//		SimpleDateFormat DateFor1 = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
//		
//		SimpleDateFormat DateFor2 = new SimpleDateFormat("EEE dd MMM");
//		
//		String stringDate1 = DateFor1.format(date);
//		String stringDate2 = DateFor2.format(date);
//		System.out.println("Date Format with MM/dd/yyyy : "+stringDate1);
//		System.out.println("Date Format with MM/dd/yyyy : "+stringDate2);
//		*/
//
//		//return null;
//		// TODO Auto-generated method stub
//		
//	}
//

}
