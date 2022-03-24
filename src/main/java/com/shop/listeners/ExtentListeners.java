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
	
//	public static ExtentTest getTest() {
//		return (ExtentTest)extentTestMap.get((int)(long)(Thread.currentThread().getId()));
//	}
	

	@Override
	public void onStart(ISuite suite) {

		try {
			waitTime(500);
			FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"/reports/"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ISuite suite) {

// 		Map<String, ISuiteResult> getResults = suite.getResults();
// 		ISuiteResult iSuiteResult = getResults.get(getResults.keySet().toArray()[0]);
// 		ITestContext iTestContext = iSuiteResult.getTestContext();
// 		String nameString = iTestContext.getName();
// 		int pass = iTestContext.getPassedTests().size();
// 		int fail = iTestContext.getFailedTests().size();
// 		int skip = iTestContext.getSkippedTests().size();
// 		int total = iTestContext.getAllTestMethods().length;
// 		String emailBody = "=============================================================\n"+
// 							nameString+"\n"+
// 							"Tests Run: "+total+", Passed: "+pass+", Failures: "+fail+", Skipped: "+skip+"\n"+
// 							"=============================================================\n";
// 		ZipUtils.generateZipFile();
// 		try {
// 			Thread.sleep(3000);
// 		} catch (InterruptedException e) {
// 			e.printStackTrace();
// 		}
		

	}
	
    
 


	
}
