package com.shop.pages;


import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.base.BaseClass;

public class PlaceAnOrderPage extends BaseClass {
	

	private WebDriver podriver = null;
	
	
	@FindBy(xpath = ("//h2[@class='name']"))
	WebElement productName;
	
	@FindBy(xpath = ("//h3[@class='price-container']"))
	WebElement productPrice;
	
	@FindBy(xpath = ("//div[@class='description description-tabs']//p"))
	WebElement productDescription;
	
	@FindBy(xpath = ("//a[text()='Add to cart']"))
	WebElement AddtoCardButton;
	
	@FindBy(xpath = ("//button[text()='Place Order']"))
	WebElement placeOrder;
	
	@FindBy(xpath = ("//input[@id='name']"))
	WebElement buyerName;
	
	@FindBy(xpath = ("//input[@id='country']"))
	WebElement buyerCountry;
	
	@FindBy(xpath = ("//input[@id='city']"))
	WebElement buyerCity;
	
	@FindBy(xpath = ("//input[@id='card']"))
	WebElement buyerCard;

	@FindBy(xpath = ("//input[@id='month']"))
	WebElement buyerMonth;
	
	@FindBy(xpath = ("//input[@id='year']"))
	WebElement buyerYear;
	
	@FindBy(xpath = ("//button[text()='Purchase']"))
	WebElement Purchase;
	
	@FindBy(xpath = ("//label[@id='totalm']"))
	WebElement totalBalance;
	
	@FindBy(xpath = ("//p[contains(@class,'text-muted')]"))
	WebElement successPopupInfo;
	
	@FindBy(xpath = ("//button[text()='OK']"))
	WebElement successPopupOk;
	
	
	
	
	
	
	
	public PlaceAnOrderPage(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}

	
	
	public boolean verifyDeletedProductFromCart(String Product,WebDriver driver) {
		try {
			isElementDisplayed(driver.findElement(By.xpath("//td[text()='"+Product+"']//following-sibling::td//a[text()='Delete']")), driver);
			return true;
		}catch (Exception e) {
			return false;
		}
		
		
	}
	
	
	public void enterName(String val, WebDriver driver) {
		waitUntilElementDisplayed(buyerName, driver);
		sendKeysToWebElement(buyerName, val, driver);
	}
	public void enterCountry(String val, WebDriver driver) {
		waitUntilElementDisplayed(buyerCountry, driver);
		sendKeysToWebElement(buyerCountry, val, driver);
	}
	public void enterCity(String val, WebDriver driver) {
		waitUntilElementDisplayed(buyerCity, driver);
		sendKeysToWebElement(buyerCity, val, driver);
	}
	public void enterCard(String val, WebDriver driver) {
		waitUntilElementDisplayed(buyerCard, driver);
		sendKeysToWebElement(buyerCard, val, driver);
	}
	public void enterMonth(String val, WebDriver driver) {
		waitUntilElementDisplayed(buyerMonth, driver);
		sendKeysToWebElement(buyerMonth, val, driver);
	}
	public void enterYear(String val, WebDriver driver) {
		waitUntilElementDisplayed(buyerYear, driver);
		sendKeysToWebElement(buyerYear, val, driver);
	}
	
	

	public void clickPurchase(WebDriver driver) {
		waitUntilElementDisplayed(Purchase, driver);
		click(Purchase, driver);
	}
	public void deleteProductFromCart(String Product,WebDriver driver) {
		waitUntilElementDisplayed(driver.findElement(By.xpath("//td[text()='"+Product+"']//following-sibling::td//a[text()='Delete']")), driver);
		click(driver.findElement(By.xpath("//td[text()='"+Product+"']//following-sibling::td//a[text()='Delete']")), driver);
	}
	
	public void clickPlaceOrderButton(WebDriver driver) {
		waitUntilElementDisplayed(placeOrder, driver);
		click(placeOrder, driver);
	}
	
	public void clickProduct(String product ,WebDriver driver) {
		waitUntilElementDisplayed(driver.findElement(By.xpath("//a[text()='"+product+"']")), driver);
		click(driver.findElement(By.xpath("//a[text()='"+product+"']")), driver);
	}
	public void clickAddtoCardButton(WebDriver driver) {
		waitUntilElementDisplayed(AddtoCardButton, driver);
		click(AddtoCardButton, driver);
	}
	public void clickSuccessPopupOk(WebDriver driver) {
		waitUntilElementDisplayed(successPopupOk, driver);
		click(successPopupOk, driver);
	}
	
	
	
	public String getProductName(WebDriver driver) {
		waitUntilElementDisplayed(productName, driver);
		return getElementText(productName, driver);
	}
	public String getProductPrice(WebDriver driver) {
		waitUntilElementDisplayed(productPrice, driver);
		return getElementText(productPrice, driver);
	}
	public String getProductDescription(WebDriver driver) {
		waitUntilElementDisplayed(productDescription, driver);
		return getElementText(productDescription, driver);
	}
	public String gettotalBalance(WebDriver driver) {
		waitUntilElementDisplayed(totalBalance, driver);
		return getElementText(totalBalance, driver);
	}
	public String getSuccessPopUpText(WebDriver driver) {
		waitUntilElementDisplayed(successPopupInfo, driver);
		return getElementText(successPopupInfo, driver);
	}
	
	
	
	
	
	
	
	public ArrayList<String> enterBuyerInfo(WebDriver driver , String Name,String Country,String City,String Card,String Month,String Year,int steps) {
		ArrayList<String> testSteps = new ArrayList<>();
		testSteps.add("Step "+(++steps)+" : Entering Name:  <b>"+Name+"</b>");
		app_logs.info(" Entering Name:  <b>"+Name+"</b>");
		enterName(Name,driver);
		
		testSteps.add("Step "+(++steps)+" : Entering Country:  <b>"+Country+"</b>");
		app_logs.info(" Entering Country:  <b>"+Country+"</b>");
		enterCountry(Country,driver);
		
		testSteps.add("Step "+(++steps)+" : Entering City:  <b>"+City+"</b>");
		app_logs.info(" Entering City:  <b>"+City+"</b>");
		enterCity(City,driver);
		
		testSteps.add("Step "+(++steps)+" : Entering Card:  <b>"+Card+"</b>");
		app_logs.info(" Entering Card:  <b>"+Card+"</b>");
		enterCard(Card,driver);
		
		testSteps.add("Step "+(++steps)+" : Entering Month:  <b>"+Month+"</b>");
		app_logs.info(" Entering Month:  <b>"+Month+"</b>");
		enterMonth(Month,driver);
		
		testSteps.add("Step "+(++steps)+" : Entering Year:  <b>"+Year+"</b>");
		app_logs.info(" Entering Year:  <b>"+Year+"</b>");
		enterYear(Year,driver);
		return testSteps;
	}
	
	
	public ArrayList<String> addProductToCart(WebDriver driver , String Laptop1,String AlertSuccessMessage,int steps) {
		ArrayList<String> testSteps = new ArrayList<>();
		testSteps.add("Step "+(++steps)+" :  <b>*********ADDING '"+Laptop1+"' IN CART*********</b>");
		testSteps.add("Step "+(++steps)+" : click On <b>'"+Laptop1+"'</b> Category");
		app_logs.info("click On <b>'"+Laptop1+"'</b> Category");
		clickProduct(Laptop1,driver);
		String productName = getProductName(driver);
		String productPrice = getProductPrice(driver);
		String productDescription = getProductDescription(driver);
		
		testSteps.add("Step "+(++steps)+" : Laptop Name:  <b>"+productName+"</b>");
		app_logs.info("Laptop Name:  <b>'"+productName+"'</b>");
		testSteps.add("Step "+(++steps)+" : Laptop Price:  <b>"+productPrice+"</b>");
		app_logs.info("Laptop Price:  <b>'"+productPrice+"'</b>");
		testSteps.add("Step "+(++steps)+" : Laptop Description:  <b>"+productDescription+"</b>");
		app_logs.info("Laptop Description:  <b>'"+productDescription+"'</b>");
		

		testSteps.add("Step "+(++steps)+" : click On <b>'Add To Cart'</b>");
		app_logs.info("click On <b>'Add To Cart'</b>");
		clickAddtoCardButton(driver);
		
		String Message = getAlertMessage(driver);
		testSteps.add("Step "+(++steps)+" : Verifing Popup Message': <b> "+Message+"</b>");
		app_logs.info("Verifing Popup Message': <b> "+Message+"</b>");
		assertEquals(Message, AlertSuccessMessage,"PopUp Success Message Mismatched");
		testSteps.add("Step "+(++steps)+" : Popup Message<b> '"+Message+"'</b> is verified");
		app_logs.info("Popup Message<b> '"+Message+"'</b> is verified");
		
		testSteps.add("Step "+(++steps)+" : click On PopUp <b>'OK'</b>");
		app_logs.info("click On PopUp <b>'OK'</b>");
		confirmAlert(driver);

		return testSteps;
		
	}
	
	
	public ArrayList<String> VerifySuccessPopupInfo(WebDriver driver,String successPopupBuyerInfo, String TotalBill, String Card, String Name, int steps) {
		ArrayList<String> testSteps = new ArrayList<>();
		String[] List = successPopupBuyerInfo.split("\n");
		testSteps.add("Step "+(++steps)+" : Generated Bill ID:  <b>'"+List[0].replace("Id:","").trim()+"'</b>");
		
		testSteps.add("Step "+(++steps)+" : Verifying Amount :  <b>'"+List[1].replace("Amount:", "").replace("USD", "").trim()+"'</b>");
		app_logs.info("Verifying Amount :  <b>'"+List[1].replace("Amount:", "").replace("USD", "").trim()+"'</b>");
		assertEquals(List[1].replace("Amount:", "").replace("USD", "").trim(),TotalBill, " Bill Amount is mismatched");
		testSteps.add("Step "+(++steps)+" : <b>'"+List[1].replace("Amount:", "").replace("USD", "").trim()+"'</b> Amount Is Verified");
		app_logs.info("<b>'"+List[1].replace("Amount:", "").replace("USD", "").trim()+"'</b> Amount Is Verified");
		
		
		
		testSteps.add("Step "+(++steps)+" : Verifying Card:  <b>'"+List[2].replace("Card Number:", "").trim()+"'</b>");
		app_logs.info("Verifying Card: '"+List[2].replace("Card Number:", "").trim()+"'");
		assertEquals(List[2].replace("Card Number:", "").trim(), Card , "Card is mismatched");
		testSteps.add("Step "+(++steps)+" : <b>'"+List[2].replace("Card Number:", "").trim()+"'</b> Card Number Is Verified");
		app_logs.info("'"+List[2].replace("Card Number:", "").trim()+"' Card Number Is Verified");
		
		testSteps.add("Step "+(++steps)+" : Verifying Name :  <b>'"+List[3].replace("Name:", "").trim()+"'</b>");
		app_logs.info("Verifying Name : '"+List[3].replace("Name:", "").trim()+"'");
		assertEquals(List[3].replace("Name:", "").trim(),Name,"Name is mismatched");
		testSteps.add("Step "+(++steps)+" :  <b>'"+List[3].replace("Name:", "").trim()+"'</b> Name is Verified");
		app_logs.info("'"+List[3].replace("Name:", "").trim()+"' Name is Verified");
		return testSteps;
	}
	
	

}
