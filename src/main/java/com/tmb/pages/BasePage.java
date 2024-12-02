package com.tmb.pages;

//part-17
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;

public class BasePage {
	//WaitStrategy waitstrategy; 
	  WebElement element;
	protected void click(By by,WaitStrategy waitstrategy,String elementname) 
	{  
		
		element=ExplicitWaitFactory.performExplicitWait(waitstrategy,by);
		element.click();
		ExtentLogger.pass(elementname+" "+by+" is clicked");	
		
		//ExplicitWaitFactory.performExplicitWait(waitstrategy,by).click();
		//DriverManager.getDriver().findElement(by).click();
	}
	protected void sendkeys(By by,String value ,WaitStrategy waitstrategy,String elementname) 
	{
		element=ExplicitWaitFactory.performExplicitWait(waitstrategy,by);
		element.sendKeys(value);
		ExtentLogger.pass("The parameter {<b>"+value+"</b>} is enterned in <b>"+elementname+"</b> and the element locater is: {<b>"+by+"</b>}");
		//ExplicitWaitFactory.performExplicitWait(waitstrategy,by).sendKeys(value);
		//DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	protected String title() 
	{
		ExtentLogger.pass("the title of the page is : "+DriverManager.getDriver().getTitle());
		return DriverManager.getDriver().getTitle();
	}

}
