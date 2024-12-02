package com.tmb.reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	

	private static final ThreadLocal<ExtentTest> etest=new ThreadLocal<>(); 
	
	static ExtentTest getExtentTest() //default --> it can only be accessed within the package
	{
		return etest.get();
	}
	
	static void setExtentTest(ExtentTest test)
	{
		etest.set(test);
	}
	static void unload()
	{
		etest.remove();
	}
	
	

}
