package com.prospection.assignment.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.prospection.base.TestBase;

public class MapViewPage  {
	
	WebDriver driver;
	
	public MapViewPage(WebDriver driver) {
		this.driver=driver;
			
			PageFactory.initElements(driver, this);
		}
	
	

	
	
	@FindBy(xpath="//div[starts-with(@class,'location-search-input-item')]")
	List<WebElement> locationsList;
	
	@FindBy(id="save-loc-button")
	WebElement btn_saveOrForgetLocation;
	
	
	@FindBy(id="location-search-box")
	WebElement locationSearchInput;
	
	@FindBy(xpath="//ul[class='search-suggest']")
	WebElement suggestedSearchList;
	
	
	@FindBy(xpath="//div[@class='gx-popup x-window-header x-unselectable']//child::div")
	WebElement forecastPopUp;
	
	@FindBy(xpath="//*[starts-with(@id,'OpenLayers_Geometry_Point')]") 
	List<WebElement> locationPins;
	
	
	@FindBy(xpath ="//div[@class='x-combo-list-inner']")
    WebElement searchComboBox;

	
	
	@FindBy(xpath="//div/span[contains(text(),'Rainfall Forecasts')]")
	WebElement rainfallForecastTab;
	
	
	@FindBy(xpath="//div/span[contains(text(),'Wind Forecasts')]")
	WebElement windForecastTab;
	
	
	@FindBy(xpath="//div/span[contains(text(),'Waves Forecasts')]")
	WebElement wavesForecastTab;

	
	@FindBy(xpath="//div/span[contains(text(),'Temperature Forecasts')]")
	WebElement tempratureForecastTab;
	
	@FindBy(xpath="//div/span[contains(text(),'UV Index Forecasts')]")
	WebElement UVIndexForecastTab;
	
	@FindBy(xpath="//div/span[contains(text(),'Humidity Forecasts')]")
	WebElement humidityForecastTab;
	
    @FindBy(xpath="//div/span[contains(text(),'Storms, Sno')]")
	WebElement stormsSnowForecastTab;

	
	
	
	public void closeForecastPopUp() {
	
		forecastPopUp.click();
	};
	
	public void clickRainFallForecastTab() {	
		
		Actions act = new Actions(driver);
		act.moveToElement(rainfallForecastTab);
		WaitForElementToBeVisible(rainfallForecastTab);

	//	WaitForElementToBeClickable(rainfallForecastTab);

		act.click().perform();
	}
	
	public void clickWavesForecastTab() {
		
		Actions act = new Actions(driver);
		act.moveToElement(wavesForecastTab);
		WaitForElementToBeVisible(wavesForecastTab);

	//	WaitForElementToBeClickable(wavesForecastTab);

		wavesForecastTab.click();
	}
	
	
	public void clickWindForecastTab() {
		Actions act = new Actions(driver);
		act.moveToElement(windForecastTab);
		
		WaitForElementToBeVisible(windForecastTab);

	//	WaitForElementToBeClickable(windForecastTab);

		act.click().perform();;
	}
	
	
	public void clickUVIndexForecastTab() {
		
		
		Actions act = new Actions(driver);
		act.moveToElement(UVIndexForecastTab);
		WaitForElementToBeVisible(UVIndexForecastTab);

		//WaitForElementToBeClickable(UVIndexForecastTab);
		
		act.click().perform();

	}
	
	
	
	
	public void clicktempratureForecastTab() {
		

		Actions act = new Actions(driver);
		act.moveToElement(tempratureForecastTab);
		WaitForElementToBeVisible(tempratureForecastTab);
        act.click().perform();
		//WaitForElementToBeClickable(tempratureForecastTab);
		tempratureForecastTab.click();
	}
	
	public void clickHumidityForecastTab() {
		
		Actions act = new Actions(driver);
		act.moveToElement(humidityForecastTab);
		WaitForElementToBeVisible(humidityForecastTab);

	//	WaitForElementToBeClickable(humidityForecastTab);
		act.click().perform();
	}
	
	
	public void clickstormsSnowForecastTab()
	{
		Actions act = new Actions(driver);
		act.moveToElement(stormsSnowForecastTab);
		WaitForElementToBeVisible(stormsSnowForecastTab);

	//	WaitForElementToBeClickable(stormsSnowForecastTab);
		act.click().perform();;
	}
	
	
	public void searchLocationViaPostCode(String postCode,String subUrb) {
		locationSearchInput.click();
		locationSearchInput.sendKeys(postCode);
		selectLocation( postCode, subUrb);
	}
	
	
	
	public void searchLocationViaSuburb(String subUrb,String postCode) {
		
		locationSearchInput.clear();
		locationSearchInput.click();
		locationSearchInput.sendKeys(subUrb);
		locationSearchInput.sendKeys(Keys.SPACE);
		
		selectLocation( postCode, subUrb);
	}
	
	private void selectLocation(String postCode, String subUrb) {
		try {
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		 for(WebElement loc : locationsList) {
			
			 
			 if(loc.getText().contains(subUrb) && loc.getText().contains(postCode)) {
				 
				 
				 act.moveToElement(loc).click().perform();
				 // method will only return true when location is found in list
				 
			 }
			
			 
		 }
		}catch(Exception e) {e.printStackTrace();}
		 
		
	}
	
	
	public void saveLocation() {
		
		btn_saveOrForgetLocation.click();
	}
	
	
public void forget() {
		
		btn_saveOrForgetLocation.click();
	}



public void ForgetSavedLocationPins() {
	
	locationPins.size();
	Actions act =  new Actions(driver);
	for(int x=0;x<locationPins.size();x++) {

			
			WebElement pin =	locationPins.get(x);
			act.moveToElement(pin).click().perform();
	
		
		forget();
		closeForecastPopUp();
	}
	
	
	
}


public void WaitForElementToBeVisible(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofSeconds(3));
	
	wait.until(ExpectedConditions.visibilityOf(element));
	
}

public void WaitForElementToBeClickable(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofSeconds(3));
	
	wait.until(ExpectedConditions.elementToBeClickable(element));
	
}


}
