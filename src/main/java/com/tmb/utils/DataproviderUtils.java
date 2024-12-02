package com.tmb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.tmb.constants.FrameworkConstants;

public class DataproviderUtils {
	
	private DataproviderUtils()
	{}
	
	public static List<Map<String,String>> listofDataMaps = new ArrayList<>();
	public static List<Map<String,String>> runmanager = new ArrayList<>();
	static String colvalue="umsss";
	
	@DataProvider(name="testdatafromexcel", parallel = true)
	public static Object[] getdata(Method m)
	{
		
		if(listofDataMaps.isEmpty())
		{
			listofDataMaps=ExcelUtils.getTestDetails(FrameworkConstants.getDatasheet());
		}
	  String test=m.getName();
		//List<Map<String,String>> listofDataMaps=ExcelUtils.getTestDetails("TESTDATA");
		List<Map<String,String>> finalList= new ArrayList<>();
		
		for(int i=0;i<listofDataMaps.size();i++)
		{
			if(listofDataMaps.get(i).get("testname").equalsIgnoreCase(test) && listofDataMaps.get(i).get("execute").equalsIgnoreCase("yes"))
				{
					finalList.add(listofDataMaps.get(i));
				}
			}
		return finalList.toArray();
		
	}
	
	public static String getvalueRunmanager(String testcasename,String Colname)
	{
		runmanager=ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagersheet());
		
		for(int i=0;i<runmanager.size();i++)
		{
			if(runmanager.get(i).get("testname").equalsIgnoreCase(testcasename))
			{
			
				colvalue= runmanager.get(i).get(Colname);
				
			}
		}
		return colvalue;
	}

	
	
	
		
	}
	


