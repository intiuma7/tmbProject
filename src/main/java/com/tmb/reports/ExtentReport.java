package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.CategoryTypes;
import com.tmb.exceptions.FrameworkExceptions;


public class ExtentReport {
	
	private ExtentReport()
	{}
	
	private static ExtentReports extent;
	//public static ExtentTest test;
	
	public static void intiReports()
	{
		if(Objects.isNull(extent)) {
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentreportfilepath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("TMB Report");
		spark.config().setReportName("Web Auto Report");
	}}
	
	
	public static void fulshReport() 
	{
		if(Objects.nonNull(extent)) {
		extent.flush();
		}
		ExtentTestManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportfilepath()).toURI());
		} catch (IOException e) {
			throw new FrameworkExceptions("custExp: While browsing the extend report"
					+ " got some I/O exception  ");
		}
		}
	
	
	public static void createTest(String Testcasename)
    {
		ExtentTest test=extent.createTest(Testcasename);
		ExtentTestManager.setExtentTest(test);
		//or
		//ExtentTestManager.setExtentTest(new extent.createTest(Testcasename));	
    }
	public static void addAuthor(String[] authors)
	{
	 for(String author:authors) {
		ExtentTestManager.getExtentTest().assignAuthor(author);
	 }
	
	}
	public static void addCategories(CategoryTypes category)
	{
		ExtentTestManager.getExtentTest().assignCategory(category.toString());
	}
	public static void addDevice(String device)
	{
		ExtentTestManager.getExtentTest().assignDevice(device);
	}
	}
