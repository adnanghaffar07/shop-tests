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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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

	public static boolean closeDriver = false;
	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	public static String browser;
	public static String env;
	public static FileInputStream fis;
//	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentTest extentReport;
	public static SoftAssert softAssert;
	public static Integer waitInSeconds = 5;
	public static Logger app_logs = Logger.getLogger("BaseClass");
	// This is the default path to imageUpload
	public static String imagePath = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\";
	public static String UtilityscreenshotPath;
	public static String UtilityscreenshotName;

	public static final int defaultTimeForVisibility = 30;
	public static final int defaultTimeTOBeClickable = 30;
	private static String screenshotPath;
	private static String screenshotNam;
	
	
	

	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setWebDriver(RemoteWebDriver driver) {
		dr.set(driver);
	}

	public static ExtentTest test;
	private static ExtentReports extent = ExtentManager
			.createInstance(System.getProperty("user.dir") + "/reports/" + "Web Automation Shop.html");

	public static WebDriver initConfiguration() {
		WebDriver localD = null;
		String log4jConfPath = System.getProperty("user.dir") +"/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		String osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\";
			imagePath = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\";
		} else {
			excelFilePath = System.getProperty("user.dir") + "/src/test/resources/data/";
			imagePath = System.getProperty("user.dir") + "/src/test/resources/images/";
		}
		System.out.println("OS : " + osName);
		System.out.println("User Dir : " + System.getProperty("user.dir"));
		System.out.println("excelFilePath  : " + excelFilePath);
		System.out.println("imagePath   : " + imagePath);
		softAssert = new SoftAssert();

		System.out.println("OS : " + System.getProperty("os.name"));
		System.out.println("User Dir : " + System.getProperty("user.dir"));
		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
			System.out.println("Browser: " + browser);
		} else {
			browser = PropertiesReader.getPropertyValue("browser");
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "gecko.exe");
			localD = new FirefoxDriver();
//			log.debug("Firefox Driver initialized");
		} else if (browser.equals("chrome")) {

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
				localD = new ChromeDriver(options);
			} catch (Exception e) {
				e.printStackTrace();
			}

//			driver.manage().window().maximize();
//			log.debug("Chrome driver intialized");
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			localD = new InternetExplorerDriver();
		}
		localD.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
		return localD;
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


	public static void UtilitycaptureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		UtilityscreenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + UtilityscreenshotName));

	}


	@AfterSuite
	public static void afterSuiteFlush() {
		extent.flush();
	}

}
