package com.tmb.tests;


import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.tmb.TestData.TestDataReaderExcel;
import com.tmb.driver.Driver;
import com.tmb.enums.ConfigProperties;
import com.tmb.reports.ExtentReport;



public class BaseTest {

	public BaseTest() {}

	@BeforeSuite
	public void beforeSuite()
	{
		//ExtentReport.intiReports();
	}
	@AfterSuite
	public void afterSuite() 
	{
		//ExtentReport.fulshReport();
	}
	
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] testdataforeachTestonObjectArray) 
	{   //testdataforeachTestonObjectArray --adds data while executing testcases runtime.
		//ExtentReport.createTest(m.getName()); --this one is now handling on listeners
		Map<String,String> data=(Map<String, String>) testdataforeachTestonObjectArray[0];
		
		String browser=data.get("browser");
		Driver.intiDriver(browser);

	}
	@AfterMethod
	protected void tearDown()
	{
		Driver.quitDriver();
	}



}
