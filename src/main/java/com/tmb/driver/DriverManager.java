package com.tmb.driver;

import org.openqa.selenium.WebDriver;

// This class is responsible for thread safety.

public final class DriverManager {
	
	private DriverManager() {}
	
	
private static final ThreadLocal<WebDriver> dr=new ThreadLocal<>(); //Generic
	
	public static void setDriver(WebDriver drRef)
	{
		dr.set(drRef);
	}
	
	public static WebDriver getDriver()
	{
		return dr.get();
	}
	
	public static void unload()
	{
		dr.remove();
	}
	

}
