package com.prospection.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	public  static WebDriver driver;
	ExtentReports extentReport;
	ExtentTest extentTest;
	public static void intialize() {
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+ "\\Driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.manage().deleteAllCookies();
		 
		 driver.get("http://www.bom.gov.au/places/nsw/sydney/");
	}

	

}
