package com.shop.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	private static ExtentTest test;
	    public static ExtentReports createInstance(String fileName) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	               
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Investor tester");
	        extent.setSystemInfo("Organization", "Investor");
	        extent.setSystemInfo("Build no", "1234");
	 	        
	        return extent;
	    }

	    
	    public static String screenshotPath;
		public static String screenshotName;
		
//		public static void captureScreenshot() {
//
//			File scrFile = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.FILE);
//
//			Date d = new Date();
//			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
//
//			try {
//				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/reports/" + screenshotName));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		

	

	}
