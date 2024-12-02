package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import com.tmb.reports.ExtentTestManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParaBankHomePage extends BasePage {
	
	
	public final By buttonlogout =By.xpath("//a[@href='logout.htm']");
	public final By buttonNewAccountXpath = By.xpath("//a[@href='openaccount.htm']");
	
	public ParaBankLoginPage clickLogout() 
	{
		click(buttonlogout,WaitStrategy.CLICKABLE,"Logout button ");
		
		//old code:ExtentReport.test.pass("The logout Button "+buttonlogout+" is clicked");	
		return new ParaBankLoginPage();
	}
	
	public ParaBankHomePage clickOpenNewAccount() 
	{
		
			click(buttonNewAccountXpath,WaitStrategy.CLICKABLE,"Open new account tab");
		
		//old code: ExtentReport.test.pass("The OpenNewAccount button "+buttonNewAccountXpath+" is clicked");
		return this;
	}
	public String pagetitle()
	{
		
		return title();
		
	}
	
	

}
