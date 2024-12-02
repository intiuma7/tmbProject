package com.tmb.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import com.tmb.reports.ExtentTestManager;

public class ParaBankLoginPage extends BasePage{
	
	public final By textboxusername = By.xpath("//input[@name='username']");
	public final By textboxpassword = By.xpath("//input[@name='password']");
	public final By buttonenter = By.xpath("//input[@type='submit']");

	public ParaBankLoginPage enterUserName(String username) 
	{
		sendkeys(textboxusername, username,WaitStrategy.PRESENT,"The user name tab ");
		
		return this;
	}

	public ParaBankLoginPage enterPassword(String password) 
	{
		sendkeys(textboxpassword, password,WaitStrategy.PRESENT,"The password tab");
		return this;
	}

	public ParaBankHomePage clickLogin() 
	{
		click(buttonenter,WaitStrategy.CLICKABLE,"Login button ");
		return new ParaBankHomePage();
	}
	
	
	
}
