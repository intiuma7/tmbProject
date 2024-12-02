package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

// This class is final it can't be extended.
// The constructor is Private we can't create object for this class using new keyword.
// The properties of this class is static and final -- we can access with the class name in the same project. 
// since it is final we should have getter and setter use the methods.

public final class FrameworkConstants {
	
	private FrameworkConstants()
	{
		//this constructor is final.
	}
	
	
	private static final String RESOURCEPATH=System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH=RESOURCEPATH+"/Config/config.properties";
	private static final int EXPLICITWAIT = 2;
	private static final String TestDataExcelPath=RESOURCEPATH+"/TestDataExcel/TestData.xlsx";
	private static final String JSONDATAFILEPATH="";
	private static final String RUNMANAGERSHEET="RUNMANAGER";
	private static final String DATASHEET="TESTDATA";
	
	
	private static final String ExtentReportFolderPath=RESOURCEPATH+"/extent-test-output/";
	private static String extentreportfilepath="";
	
	
	public static String getConfigfilepath(){
		return CONFIGFILEPATH;
	}

	/**
	 * @return the explicitwait
	 */
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getTestdataexcelpath() {
		return TestDataExcelPath;
	}

	public static  String getExtentreportfilepath() {
		
		if(extentreportfilepath.isEmpty())
		{
			extentreportfilepath= getextentreportFolderpath();
		}
		return  extentreportfilepath;
	}
	
	public static String getextentreportFolderpath() 
	{
		if(PropertyUtils.getVal(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
		{
			return ExtentReportFolderPath+System.currentTimeMillis()+"/index.html";
		}
		else return ExtentReportFolderPath+"/index.html";
	}

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getDatasheet() {
		return DATASHEET;
	}
	

	
}
