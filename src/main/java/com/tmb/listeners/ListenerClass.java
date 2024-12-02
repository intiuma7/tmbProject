package com.tmb.listeners;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.model.Test;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.CategoryTypes;
import com.tmb.enums.ConfigProperties;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import com.tmb.utils.DataproviderUtils;
import com.tmb.utils.ExcelUtils;
import com.tmb.utils.PropertyUtils;

import annotations.FrameworkAnnotation;

public class ListenerClass implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {	
			ExtentReport.intiReports();	
	}

	@Override
	public void onFinish(ISuite suite) {

			
				ExtentReport.fulshReport();
			
	}
	@Override
	//We created extend report,added desc,category and author from excel.
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
	/*	//***************************author and category from excel***********************************************
		//Getting the String author from excel and splitting with comma and storing into a string arrya
		// can be done same for category.
        String author=DataproviderUtils.getvalueRunmanager(result.getMethod().getMethodName(), "author");
        String[] authors=author.split(",");
        String category=DataproviderUtils.getvalueRunmanager(result.getMethod().getMethodName(), "category");
      
        ExtentReport.addAuthor(authors);
        ExtentReport.addCategories(category);
     */
		//From user defined annotation
		
		String[] authors=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author();
		ExtentReport.addAuthor(authors);
		CategoryTypes category=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category();
		ExtentReport.addCategories(category);

		//**************************************************************************
		//Description is already set on method intercepter
		String description=result.getMethod().getDescription();
		ExtentLogger.info("<b>Description : </b>"+description);
		//**************************************************************************
		//the object array is giving us parameters entered when the run time
		//it holds the test parameters we entered from excel.	
		Object[] ob=result.getParameters();
		//getting the map from object array.
	    Map<String,String> map= (Map<String, String>) ob[0];
		String  browserName=map.get("browser");  
		ExtentReport.addDevice(browserName);
	    ExtentLogger.info("<b>"+PropertyUtils.getVal(ConfigProperties.URL)+"</b> has entered in {<b>"+browserName+"</>}");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
			ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

			ExtentLogger.fail(result.getMethod().getMethodName()+" is failed");
			ExtentLogger.fail(result.getThrowable().toString());
		//it gives array of the method but we need a string so we used Arrays.toString to change it as string
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
			ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
		}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);
	}

}
