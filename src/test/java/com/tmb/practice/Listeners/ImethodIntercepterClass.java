package com.tmb.practice.Listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.TestData.TestDataReaderExcel;

public class ImethodIntercepterClass implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		// The argument list contains list of methods on test execution. below code runs only first method in 
		//test class since we are passing only 0th index to result arraylist from list of methods.

		List<IMethodInstance> result=new ArrayList<>();


		Map<String,String> map1=new HashMap<>();
		map1.put("testname", "test1");
		map1.put("count", "3");
		Map<String,String> map2=new HashMap<>();
		map2.put("testname", "test2");
		map2.put("count", "2");

		List<Map<String,String>> ListofMaps=new ArrayList<>();

		ListofMaps.add(map1);
		ListofMaps.add(map2);


		for(int i=0;i<methods.size();i++)
		{
			for(int j=0;j<ListofMaps.size();j++)
			{
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase((String) ListofMaps.get(j).get("testname")))
				{
				methods.get(i).getMethod().setInvocationCount(Integer.parseInt( ListofMaps.get(j).get("count")));
                  result.add(methods.get(i));
				}
			}
		}





		return result;
	}

}
