package com.shop.base;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.shop.listeners.ExtentManager;
import com.shop.utilities.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends Utility {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	public static String browser;
	public static FileInputStream fis;
	public static ExtentTest extentReport;
	public static SoftAssert softAssert;
	public static Integer waitInSeconds = 5;
	public static Logger app_logs = Logger.getLogger("BaseClass");
	public static final int defaultTimeForVisibility = 30;
	public static final int defaultTimeTOBeClickable = 30;
	private static String screenshotPath;
	private static String screenshotNam;
	public static String url = PropertiesReader.getPropertyValue("url");
	public static String log4jConfPath = System.getProperty("user.dir") +"/src/test/resources/config/log4j.properties";
	public static String ReportPath = System.getProperty("user.dir")+"/reports/";
	
	

	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setWebDriver(RemoteWebDriver driver) {
		dr.set(driver);
	}

	public static ExtentTest test;
	private static ExtentReports extent = ExtentManager
			.createInstance(System.getProperty("user.dir") + "/reports/" + "Web_Automation_Shop_"+getTimeStamp()+".html");

	public static WebDriver initConfiguration() {
		WebDriver localDriver = null;	
		PropertyConfigurator.configure(log4jConfPath);
		softAssert = new SoftAssert();

		app_logs.info("OS : " + System.getProperty("os.name"));
		app_logs.info("User Dir : " + System.getProperty("user.dir"));
		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
			app_logs.info("Browser: " + browser);
		} else {
			browser = PropertiesReader.getPropertyValue("browser");
		}
		 if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			String agentString = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36";
			options.addArguments("--user-agent=" + agentString);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("window-size=1920,1080");
//			options.addArguments("--headless");
//			options.addArguments("--disable-gpu");
			try {
				localDriver = new ChromeDriver(options);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} 
		 localDriver.manage().window().maximize();
		localDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
		return localDriver;
	}

	/////////////////////////////////////////////////
	public static String getTimeStamp() {
		return new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new Date()).replaceAll("[-: ]", "_");
	}


	////////////////////////////////////////////////////////////

	public static void AddTest_IntoReport(String TestName, ArrayList<String> test_steps, WebDriver localDriver) {
		test = extent.createTest(TestName);
		for (int i = 0; i < test_steps.size(); i++) {

			if (test_steps.get(i).contains("Failed") || test_steps.get(i).contains("Assertion")) {
				if (test_steps.get(i).toLowerCase().contains("screenshot")) {
					printString("Name" + test_steps.get(i),driver);
					try {

						test.log(Status.FAIL, "<b>" + "<font color=" + "black>" + "Screenshot" + "</font>" + "</b>",
								MediaEntityBuilder.createScreenCaptureFromPath(test_steps.get(i)).build());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {

					test.log(Status.FAIL, test_steps.get(i));

				}
			} else {
				if (test_steps.get(i).toLowerCase().contains("screenshot")) {
					printString("Name" + test_steps.get(i),driver);
					try {
						test.log(Status.PASS, "<b>" + "<font color=" + "black>" + "Screenshot" + "</font>" + "</b>",
								MediaEntityBuilder.createScreenCaptureFromPath(test_steps.get(i)).build());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {

					test.log(Status.PASS, test_steps.get(i));

				}
			}
		}
		test_steps.clear();
		closeBrowser(localDriver);
		}

	public static String getScreenshotPath() {
		Date d = new Date();
		return screenshotNam = "ScreenShot" + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
	}

	public static void captureScreen(WebDriver localDriver, String screen) {

		File scrFile = ((TakesScreenshot) localDriver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotNam = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/reports/" + screen));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}



	@AfterSuite
	public static void afterSuiteFlush() {
		extent.flush();
	}

}
