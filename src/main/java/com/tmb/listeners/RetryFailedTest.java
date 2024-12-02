package com.tmb.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public class RetryFailedTest implements IRetryAnalyzer {
	private	int retries=1;
	private	int count=0;
	@Override
	public boolean retry(ITestResult result) {
		 boolean value =false;
		try {
			if(PropertyUtils.getVal(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
			{
			    value=count<retries;
			    count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
			
	//		or
	//	if(count<retries)
	//	{
	//		count++;
	//		return true;
	//	}
	//	else return false;
		}
		
	}
	
	
	
	
	


