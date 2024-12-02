package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tmb.pages.ParaBankHomePage;
import com.tmb.pages.ParaBankLoginPage;
import com.tmb.tests.BaseTest;

import annotations.FrameworkAnnotation;

public class ParaBankHomepageTest  extends BaseTest{
	

	ParaBankLoginPage pb=new ParaBankLoginPage();
	ParaBankHomePage pbHomeP=new ParaBankHomePage();
    @FrameworkAnnotation
	@Test 
	public void VerifyHomepageandLogoutTest(Map<String,String> map) 
	{
		//*********below we used method chaining to reduce the code******************
		String title=pb.enterUserName(map.get("username")).enterPassword(map.get("password")).clickLogin().pagetitle();
		Assertions.assertThat(title)
		      .as("The Title mismatch").containsIgnoringCase("ParaBank");
		pbHomeP.clickOpenNewAccount().clickLogout();
	}
	

}
