package com.tmb.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.tmb.driver.DriverManager;

public final class ScreenshotUtils { //final - no one can extend.
	
	private ScreenshotUtils()  //no one can create an object since it is private
	{}
	public static String getBase64image()
	{
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
}
