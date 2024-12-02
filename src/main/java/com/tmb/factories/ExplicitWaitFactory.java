package com.tmb.factories;
// this class is making elements into web elements
// The locators transformed to web elements shown below..
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class ExplicitWaitFactory {
	
	private ExplicitWaitFactory()
	{}
	
	public static WebElement performExplicitWait(WaitStrategy waitstrategy,By by)
	{
		WebElement element=null;
		if(waitstrategy == WaitStrategy.CLICKABLE)
		{
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
	       element = wait.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitstrategy == WaitStrategy.PRESENT)
		{
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
			element =wait.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitstrategy == WaitStrategy.VISIBLE)
		{
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
			element= wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitstrategy == WaitStrategy.NONE)
		{
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
