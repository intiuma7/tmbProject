package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.tmb.driver.DriverManager;
import com.tmb.enums.CategoryTypes;
import com.tmb.listeners.RetryFailedTest;
import com.tmb.pages.ParaBankHomePage;
import com.tmb.pages.ParaBankLoginPage;
import com.tmb.reports.ExtentReport;
import com.tmb.utils.DataproviderUtils;

import annotations.FrameworkAnnotation;

public class ParaBankLoginTest extends BaseTest{
   
	
	ParaBankLoginPage pb=new ParaBankLoginPage();
	ParaBankHomePage pbHomeP=new ParaBankHomePage();
    
	
	@FrameworkAnnotation (author= {"uma1","uma2"},category=CategoryTypes.REGRESSION)
	@Test
	public void loginLogoutTest(Map<String,String> map) 
	//(Map<String,String> map),(String username,String passwrd)
	{	
		//*********below we used method chaining to reduce the code******************
		String title=pb.enterUserName(map.get("username")).enterPassword(map.get("password")).clickLogin().pagetitle();
		Assertions.assertThat(title)
		        .as("The Title mismatch").containsIgnoringCase("ParaBank");
		pbHomeP.clickLogout();

	}
	
	@Test
	public void verifyLoginpagehasRegistertab(Map<String,String> map) throws Exception
	{
		//*********below we used method chaining to reduce the code******************
				String title=pb.enterUserName(map.get("username")).enterPassword(map.get("password")).clickLogin().pagetitle();
				Assertions.assertThat(title)
				        .as("The Title mismatch").containsIgnoringCase("ParaBank");
				pbHomeP.clickLogout();
	}

}
