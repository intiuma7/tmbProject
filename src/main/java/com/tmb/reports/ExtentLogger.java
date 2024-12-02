package com.tmb.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.driver.DriverManager;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;
import com.tmb.utils.ScreenshotUtils;

public class ExtentLogger {
	
	private ExtentLogger(){}
	
	//public static void pass(String message)
	{
		//ExtentTestManager.getExtentTest().pass(message);
	}
	//public static void fail(String message)
	{
	//	ExtentTestManager.getExtentTest().fail(message);
	}
	//public static void skip(String message)
	{
		//ExtentTestManager.getExtentTest().skip(message);
	}
	public static void info(String message)
	{
		ExtentTestManager.getExtentTest().info(message);
	}
	
	public static void pass(String message) 
	{
		if(PropertyUtils.getVal(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes"))
		{
			ExtentTestManager.getExtentTest().
			pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64image()).build());
		}
		else
			ExtentTestManager.getExtentTest().pass(message);
	}
	
	public static void fail(String message)
	{
		if(PropertyUtils.getVal(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes"))
		{
			ExtentTestManager.getExtentTest().
			fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64image()).build());
		}
		else
			ExtentTestManager.getExtentTest().fail(message);
	}
	
	public static void skip(String message) 
	{
		if(PropertyUtils.getVal(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes"))
		{
			ExtentTestManager.getExtentTest().
			skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64image()).build());
		}
		else
			ExtentTestManager.getExtentTest().skip(message);
	}
	
	

}
