package com.tmb.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.pages.ParaBankUserRegistration;

public class ParaBankUserRegistrationTest extends BaseTest{
	
	//Registering a user, Verifying the title and registration confirmation
	
	@Test
	public void verifyUserRegistration() 
	{
		ParaBankUserRegistration paraReg=new ParaBankUserRegistration();
		String ConfirmationText=paraReg.clickRegistrationLink().
				fillTheRegistrationForm().RegistrationConfirmation();
		Assertions.assertThat(ConfirmationText).as("Couldn't find the text - Your account was created successfully. You are now logged in.").contains("Your account was created successfully. You are now logged in.");
		
	}
	
	
	
	

}
