package com.course.chapter5;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicAnnotion {

	
	@BeforeSuite
	public void BeforeSuite1() {
		System.out.println("这是beforeSuite");
	} 
	
	@AfterSuite
	public void AfterSuite1() {
		System.out.println("这是AfterSuite");
	}

	@BeforeClass
	public void BeforeClass1() {
		System.out.println("这是beforeClass");
	} 
	
	@AfterClass
	public void AfterClass1() {
		System.out.println("这是AfterClass");
	}
	
	@BeforeMethod
	public void BeforeMethod1() {
		System.out.println("这是beforeMethod");
	} 

	@AfterMethod
	public void AfterMethod1() {
		System.out.println("这是AfterMethod");
	}
	
	@Test(enabled = true)
	public void Test1() {
		System.out.println("这是Test1");
	}
	
	@Test(enabled = false)
	public void Test2() {
		System.out.println("这是Test2");
	}
	
	@Test(dependsOnMethods = {"Test1"})
	public void Test3() {
		System.out.println("这是Test3");
	}
	
}
