package com.tmb.practice.Listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.IListenersAnnotation;
import org.testng.annotations.ITestAnnotation;

public class IAnnotationTransformerClass implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//we can set a test enable or we can make changes on annotation for any test using this listener 
	
		
		if(testMethod.getName().equalsIgnoreCase("test1"))
		{
			annotation.setInvocationCount(2);
			annotation.setRetryAnalyzer(retry.class);//it will tell the test to retry if test fails.
			
		}
		
		
	}

	

}
