package com.prospection.assignment.TestCases;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.prospection.assignment.pages.MapViewPage;
import com.prospection.assignment.pages.WeatherOverviewPage;
import com.prospection.base.TestBase;

import junit.framework.Assert;

public class TestWeatherView extends TestBase{
	
	
	 @DataProvider (name = "data-set")
     public Object[][] dataProvider(Method callingMethod){
		 switch (callingMethod.getName()) {
		 
		 case "SearchandSaveLocations":
			 return new Object[][] {{"2217","Kogarah"}, {"2508","Helensburgh"},{"2533","Kiama"},{"2095","Manly"}};
		 
	 
     }
		 
		 return null;
	 }
	
	@BeforeMethod
	public void setUp(){
		intialize();
	}

	
	@Test(dataProvider="data-set",description="User navigates from weather overview page to map view page searches and saves the location")
	public void SearchandSaveLocations(String postCode,String subUrb) {
		
		
		WeatherOverviewPage weatherOverViewPage =new WeatherOverviewPage(driver);
		MapViewPage mapViewPage = new MapViewPage(driver); 
		
		weatherOverViewPage.clickMapView();

		mapViewPage.searchLocationViaPostCode(postCode,subUrb);
		
		mapViewPage.saveLocation();
		mapViewPage.closeForecastPopUp();		

		
		mapViewPage.clickRainFallForecastTab();
		mapViewPage.clickHumidityForecastTab();
		mapViewPage.clickstormsSnowForecastTab();
		mapViewPage.clicktempratureForecastTab();
		mapViewPage.clickUVIndexForecastTab();
		mapViewPage.clickWindForecastTab();
	
		}
	
	
	@Test (dependsOnMethods="SearchandSaveLocations",description="Navigate to map view and forget the saved locations ")
	public void ForgetSavedLocations()
	
	
	
	{
		
		WeatherOverviewPage weatherOverViewPage =new WeatherOverviewPage(driver);
		
		
		MapViewPage mapViewPage = new MapViewPage(driver); 
		
		weatherOverViewPage.clickMapView();

		mapViewPage.ForgetSavedLocationPins();
		
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
