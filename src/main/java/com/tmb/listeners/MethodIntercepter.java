package com.tmb.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.constants.FrameworkConstants;
import com.tmb.reports.ExtentReport;
import com.tmb.utils.DataproviderUtils;
import com.tmb.utils.ExcelUtils;

public class MethodIntercepter implements IMethodInterceptor{
   
// the method intercepter class is used to change the methods information at runtime. 
// it occurs before test execution starts. below we are setting testcases to be executed 
// based on excel data execute is yes and storing in tobeexecuted arylist and returning the same.
	
	
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
	
		List<Map<String,String>> tests = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagersheet());
		List<IMethodInstance> tobeExecuted =new ArrayList<>();
		int totaltests=methods.size();
		
		for(int i=0;i<methods.size();i++)
		{
			for(int j=0;j<tests.size();j++)
			{
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(tests.get(j).get("testname"))
						&& 	tests.get(j).get("execute").equalsIgnoreCase("yes"))
					{   
					
					methods.get(i).getMethod().setDescription(tests.get(j).get("testdescription"));
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(tests.get(j).get("count")));
					methods.get(i).getMethod().setPriority(Integer.parseInt(tests.get(j).get("priority")));
					tobeExecuted.add(methods.get(i));
					}
				
			}
		}
		
		
		return tobeExecuted;
	}

}
