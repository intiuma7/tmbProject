package com.tmb.driver;

import java.util.Objects;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Author : Uma
 * 
 */
public final class Driver {
	
	private Driver()
	{}
	
	//private static WebDriver driver;
	
	
	
	public static void intiDriver(String browser) 
	{
		//instead of driver==null we can use a class called Objects by utils to check driver is null or not null.
		if(Objects.isNull(DriverManager.getDriver())) {
	
			switch(browser)
			{
			case "chrome" :
				  WebDriverManager.chromedriver().setup();
			      DriverManager.setDriver(new ChromeDriver());
			      break;
			case "edge":
				  WebDriverManager.edgedriver().setup();
			      DriverManager.setDriver(new EdgeDriver());
			      break;
			
			}
		DriverManager.getDriver().get(PropertyUtils.getVal(ConfigProperties.URL));	
		WebDriverManager.chromedriver().setup();
		DriverManager.getDriver().manage().window().maximize();
		}
	}

	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
		//driver=null; // this statement is must since we are checking if driver == null 
		DriverManager.unload();  // we are removing the dr(Threadlocal object), not the driver.
		}
	}

}
