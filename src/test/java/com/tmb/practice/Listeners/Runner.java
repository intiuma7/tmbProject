package com.tmb.practice.Listeners;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.*;

//simple set of tests along with before and after suite and method.

public class Runner {

	@BeforeSuite
	public void setUpSuite()
	{
		System.out.println("before suite in runner");
	}
	@BeforeMethod
	public void setUpMethod()
	{
		System.out.println("before method in runner");
	}
	@AfterSuite
	public void endSuite()
	{
		System.out.println("end suite in runner");
	}
	@AfterMethod
	public void endMethod()
	{
		System.out.println("end method in runner");
	}
	@Test
	public void test1()
	{
		Assert.assertTrue(false);
		System.out.println("Test1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Test2");
	}
	@Test
	public void test3()
	{
		System.out.println("Test3");
	}
	
	
	
}
