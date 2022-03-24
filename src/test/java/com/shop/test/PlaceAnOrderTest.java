package com.shop.test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.shop.base.BaseClass;
import com.shop.base.PropertiesReader;
import com.shop.pages.DashboardPage;
import com.shop.pages.PlaceAnOrderPage;

public class PlaceAnOrderTest extends BaseClass {
	String tempSrc = "";

	@Test
	public void verifyOrderPlacement() throws IOException {
		WebDriver driver = null;
		ArrayList<String> testSteps = new ArrayList<>();
		PlaceAnOrderPage sp;
		DashboardPage dp;
		driver = initConfiguration();
		app_logs.info("verify Order Placement:" + driver.hashCode());
		sp = new PlaceAnOrderPage(driver);
		dp = new DashboardPage(driver);
		int steps = 0;
		String Laptop1 = "Sony vaio i5";
		String Laptop2 = "Dell i7 8gb";
		String AlertSuccessMessage = "Product added";
		String Name = "AdnanGhaffar";
		String Country = "UnitedKingdom";
		String City = "England";
		String Card = "12341234123412";
		String Month = "Jan";
		String Year = "2022";
		String TotalBill = "";
		String successPopupBuyerInfo = "";
		int actualSteps = 0;
		int addedSteps = 0;
		try {

			testSteps.add("Step "+(++steps)+" : Navigate to url: <b>"+PropertiesReader.getPropertyValue("url")+"'</b>");
			app_logs.info(" Navigate to url");
			navigateToURL(PropertiesReader.getPropertyValue("url"), driver);
			
			testSteps.add("Step "+(++steps)+" : Verifying <b>'HomePage'</b>");
			app_logs.info("Verifying <b>'HomePage'</b>");
			assertTrue(dp.VerifyHomePage(driver));
			testSteps.add("Step "+(++steps)+" : <b>'HomePage'</b> is Verified");
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureScreen(driver, tempSrc);
			
			
			testSteps.add("Step "+(++steps)+" : click On <b>'Monitors'</b> Category");
			app_logs.info("click On <b>'Monitors'</b> Category");
			dp.clickMonitorsCategory(driver);
			testSteps.add("Step "+(++steps)+" : click On <b>'Phone'</b> Category");
			app_logs.info(" click On <b>'Phone'</b> Category");
			dp.clickPhoneCategory(driver);
			testSteps.add("Step "+(++steps)+" : click On <b>'Laptops'</b> Category");
			app_logs.info(" click On <b>'Laptops'</b> Category");
			dp.clickLaptopsCategory(driver);

			actualSteps = testSteps.size();
			testSteps.addAll(sp.addProductToCart(driver, Laptop1, AlertSuccessMessage, steps));
			addedSteps = testSteps.size() - actualSteps;
			steps =  steps + addedSteps;
			
			
			testSteps.add("Step "+(++steps)+" : click On <b>'Home'</b>");
			app_logs.info(" click On <b>'Home'</b>");
			dp.clickhomeNavigationButton(driver);
			
			testSteps.add("Step "+(++steps)+" : click On <b>'Laptops'</b> Category");
			app_logs.info(" click On <b>'Laptops'</b> Category");
			dp.clickLaptopsCategory(driver);
			
			actualSteps = testSteps.size();
			testSteps.addAll(sp.addProductToCart(driver, Laptop2, AlertSuccessMessage, steps));	
			addedSteps = testSteps.size() - actualSteps;
			steps =  steps + addedSteps;
			
			
			testSteps.add("Step "+(++steps)+" : click On <b>'Cart'</b>");
			app_logs.info(" click On <b>'Cart'</b>");
			dp.clickcartNavigationButton(driver);
			
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureScreen(driver, tempSrc);
			
			testSteps.add("Step "+(++steps)+" : Removing <b>'"+Laptop2+"'</b>");
			app_logs.info(" Removing <b>'"+Laptop2+"'</b>");
			sp.deleteProductFromCart(Laptop2,driver);
			
			testSteps.add("Step "+(++steps)+" : Verifing <b>'"+Laptop2+"'</b> is deleted successfully");
			app_logs.info(" Verifing <b>'"+Laptop2+"'</b> is deleted successfully");
			assertFalse(sp.verifyDeletedProductFromCart(Laptop2, driver));
			testSteps.add("Step "+(++steps)+" : Verified that <b>'"+Laptop2+"'</b> is deleted successfully");
			app_logs.info("Verified:  <b>'"+Laptop2+"'</b> is deleted successfully");
			
			
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureScreen(driver, tempSrc);
			
			testSteps.add("Step "+(++steps)+" : click On <b>'place Order'</b>");
			app_logs.info(" click On <b>'place Order'</b>");
			sp.clickPlaceOrderButton(driver);
			
			TotalBill = sp.gettotalBalance(driver).replace("Total:", "").trim();
			testSteps.add("Step "+(++steps)+" : Total Bill:  <b>'"+TotalBill+"'</b>");
			app_logs.info(" Total Bill:  <b>'"+TotalBill+"'</b>");
			
			actualSteps = testSteps.size();
			testSteps.addAll(sp.enterBuyerInfo(driver, Name, Country, City, Card, Month, Year, steps));
			addedSteps = testSteps.size() - actualSteps;
			steps =  steps + addedSteps;
			
			
			
			testSteps.add("Step "+(++steps)+" : click On <b>'Purchase'</b>");
			app_logs.info(" click On <b>'Purchase'</b>");
			sp.clickPurchase(driver);
			
			
			actualSteps = testSteps.size();
			successPopupBuyerInfo = sp.getSuccessPopUpText(driver);
			testSteps.addAll( sp.VerifySuccessPopupInfo(driver,successPopupBuyerInfo,TotalBill,Card,Name,steps));
			addedSteps = testSteps.size() - actualSteps;
			steps =  steps + addedSteps;
			
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureScreen(driver, tempSrc);
			
			testSteps.add("Step "+(++steps)+" : click On <b>'Ok'</b>");
			app_logs.info(" click On <b>'Ok'</b>");
			sp.clickSuccessPopupOk(driver);
			
			
			testSteps.add("Step "+(++steps)+" : Close the Browser");
			app_logs.info(" Close the Browser");
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureScreen(driver, tempSrc);
			AddTest_IntoReport("verify Order Placement", testSteps, driver);

		} catch (Exception e) {
			e.printStackTrace();
			testSteps.add("Failed: verify Order Placement " + "<br><b>Exception:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureScreen(driver, tempSrc);
			AddTest_IntoReport("verify Order Placement", testSteps, driver);
			assertTrue(false);
		} catch (Error e) {
			e.printStackTrace();
			testSteps.add("Failed: verify Order Placement " + "<br><b>Error:</b><br> " + e.toString());
			tempSrc = getScreenshotPath();
			testSteps.add(tempSrc);
			captureScreen(driver, tempSrc);
			AddTest_IntoReport("verify Order Placement", testSteps, driver);
			assertTrue(false);
		}
	}


}
