package com.qa.tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {		
    private WebDriver driver;	
    static ExtentTest test;
    static ExtentReports report;
	@Test				
	public void testEasy() {	
		driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		//AssertJUnit.assertTrue(title.contains("Demo Guru99 Page"));
		if(driver.getTitle().equals("Demo Guru99 Page"))
		{
		test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");
		}
		
	}	
	@BeforeTest
	public void beforeTest() {	
		 System.setProperty("webdriver.chrome.driver", "/C://Users//Sumit.kapur//Downloads//chromedriver_win32/chromedriver.exe");
	    driver = new ChromeDriver();  
	    report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	    test = report.startTest("ExtentDemo");
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();	
		report.endTest(test);
		report.flush();
	}		
}	
