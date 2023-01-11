package com.prospection.assignment.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prospection.base.TestBase;

public class MapViewPage  {
	
	
	WebDriver driver;
	
	@FindBy(id="location-search-box")
	WebElement locationSearchInput;
	
	
	
	@FindBy(xpath="//input[@value='Search']")
	WebElement btnSearch;
	
	@FindBy(xpath="//a[contains(text(),'Map View')]")
	WebElement mapViewLink;
	
	@FindBy(xpath="//ul[class='search-suggest']")
	WebElement suggestedSearchList;
	
	public MapViewPage(WebDriver driver) {
	this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void searchLocationViaPostCode(String postCode,String subUrb) {
		locationSearchInput.click();
		locationSearchInput.sendKeys(postCode);
		selectLocation( postCode, subUrb);
	}
	private boolean selectLocation(String postCode, String subUrb) {
		
		List<WebElement> locationsList = driver.findElements(By.xpath("//ul[@class='search-suggest']/li"));
		
		 for(WebElement loc : locationsList) {
			 if(loc.getText().contains(subUrb) && loc.getText().contains(postCode)) {
				 loc.click();
				 // method will only return true when location is found in list
				 return true;
			 }
			
			 
		 }
		 return false;
		
	}


	public void searchLocationViaSuburbName(String subUrb,String postCode) {
		locationSearchInput.click();
		locationSearchInput.sendKeys(subUrb);
		selectLocation( postCode, subUrb);
	}

	
	
}
