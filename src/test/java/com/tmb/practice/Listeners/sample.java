package com.tmb.practice.Listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.ITestContext;

import com.tmb.TestData.TestDataReaderExcel;

public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		// The argument list contains list of methods on test execution. below code runs only first method in 
		//test class since we are passing only 0th index to result arraylist from list of methods.
		
		List<IMethodInstance> result=new ArrayList<>();
		result.add(methods.get(0));
		
		Object[] ob=new Object[methods.size()];
		List<Map<String,Object>> list=new ArrayList<>();
	
		try {
			ob=TestDataReaderExcel.TestData();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Object obj:ob)
		{ 
			list.add((Map<String, Object>) obj);
		}
		
		//Created new list for the test cases which are having yes as on execute column on excel.
		List<Map<String,Object>> YesTests=new ArrayList<>();
		Map<String,Object> mp;
		
		for(int i=0;i<list.size();i++)
		{
		mp=	list.get(i);
		if(mp.get("execute")== "yes")
		{
			YesTests.add(mp);
		}
			
		}
		
		return result;
	}


}
