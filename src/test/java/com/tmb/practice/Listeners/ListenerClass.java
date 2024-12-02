package com.tmb.practice.Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener,ISuiteListener{

	
	@Override
	public void onStart(ISuite suite) {
		 System.out.println("onStart suite in listener");
	}

	@Override
	public void onFinish(ISuite suite) {
		 System.out.println("onFinish suite in listener");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
	 System.out.println("onTestStart in listener");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 System.out.println("onTestSuccess in listener");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 System.out.println("onTestFailure in listener");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 System.out.println("onTestSkipped in listener");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 //System.out.println("onTestStart in listener");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// System.out.println("onTestStart in listener");
	}


}
