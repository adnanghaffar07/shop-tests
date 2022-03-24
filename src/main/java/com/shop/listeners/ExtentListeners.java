package com.shop.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.shop.base.BaseClass;


public class ExtentListeners extends BaseClass implements ITestListener,ISuiteListener {

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public static void attachScreenShot(String name) {

	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stubv
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
	
	

	@Override
	public void onStart(ISuite suite) {
		try {
			waitTime(500);
			FileUtils.cleanDirectory(new File(ReportPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ISuite suite) {

		// TODO Auto-generated method stub
		

	}
	
    
 


	
}
