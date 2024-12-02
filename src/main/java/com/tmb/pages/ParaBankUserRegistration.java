package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public class ParaBankUserRegistration extends BasePage {
	
	//public final By RegistrationForm_xpath =By.xpath("//table//tr["+"1"+"]//input");
	
	public static By RegistrationForm_xpath(int value)
	{
		By RegistrationForm_xpath =By.xpath("//table//tr["+value+"]//input");
		return RegistrationForm_xpath;
	}
	
	public final By RegistrationConfirmationxpath= By.xpath("//div[@id='rightPanel']//p"); //Your account was created successfully. You are now logged in.
	public final By ClickOnRegisrationxpath=By.xpath("//div[@id='loginPanel']//p[2]/a");
    public ParaBankUserRegistration getTitle() throws Exception
    {
    	title();
		return this;
    	
    }
    public ParaBankUserRegistration clickRegistrationLink() 
    {
    	click(ClickOnRegisrationxpath, WaitStrategy.CLICKABLE,"Registration button");
    	return this;
    }
    
	public ParaBankUserRegistration fillTheRegistrationForm() 
	{
		sendkeys(RegistrationForm_xpath(1),"UserName",WaitStrategy.PRESENT,"Registration form");
		sendkeys(RegistrationForm_xpath(2),"LastName",WaitStrategy.PRESENT,"Registration form");
		sendkeys(RegistrationForm_xpath(3),"address",WaitStrategy.PRESENT,"Registration form");
		sendkeys(RegistrationForm_xpath(4),"city",WaitStrategy.PRESENT,"Registration form");
		sendkeys(RegistrationForm_xpath(5),"State",WaitStrategy.PRESENT,"Registration form");
		sendkeys(RegistrationForm_xpath(6),"12345",WaitStrategy.PRESENT,"Registration form");
		sendkeys(RegistrationForm_xpath(7),"9999988855",WaitStrategy.PRESENT,"Registration form");
		sendkeys(RegistrationForm_xpath(8),"85236974",WaitStrategy.PRESENT,"Registration form");
		sendkeys(RegistrationForm_xpath(10),"user1",WaitStrategy.PRESENT,"Registration form");
		sendkeys(RegistrationForm_xpath(11),"user1",WaitStrategy.PRESENT,"Registration form");
		sendkeys(RegistrationForm_xpath(12),"user1",WaitStrategy.PRESENT,"Registration form");
		click(RegistrationForm_xpath(13),WaitStrategy.CLICKABLE,"registration Submit button");
		
		
		return this;
	}
	
	public String RegistrationConfirmation()
	{
		String ConfirmationText=DriverManager.getDriver().findElement(RegistrationConfirmationxpath).getText();
		return ConfirmationText;
	}
	
	
}
