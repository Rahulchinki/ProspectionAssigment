package com.prospection.assignment.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prospection.assignment.pages.MapViewPage;
import com.prospection.base.TestBase;

public class TestWeatherView extends TestBase{
	
	@BeforeMethod
	public void setUp(){
		intialize();
	}

	
	@Test
	public void TestBrowser() {
		MapViewPage mapViewPage =new MapViewPage(driver);

		mapViewPage.searchLocationViaPostCode("2217", "Kogarah");
		
		
		
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
