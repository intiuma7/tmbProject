package com.tmb.practice.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer {

	
	
	private static int counter=0;
	private static int limit=2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(counter<limit)
		{
			counter++;
			return true;
			
		}
		else 
		return false;
	}
	
	

}
