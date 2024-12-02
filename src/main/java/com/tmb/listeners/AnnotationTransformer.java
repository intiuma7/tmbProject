package com.tmb.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.tmb.utils.DataproviderUtils;

public class AnnotationTransformer implements IAnnotationTransformer{
  
	ITestAnnotation annotation;
	
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		
		 annotation.setDataProvider("testdatafromexcel");  // it is data provider name on dataprovider utils class
		 annotation.setDataProviderClass(DataproviderUtils.class);
		 annotation.setRetryAnalyzer(RetryFailedTest.class);
		
		
	}
	
	

}
