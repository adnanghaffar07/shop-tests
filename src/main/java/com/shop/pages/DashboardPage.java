package com.shop.pages;


import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shop.base.BaseClass;

public class DashboardPage extends BaseClass {
	

	private WebDriver podriver = null;
	
	
	@FindBy(xpath = ("//a[contains(text(),'Home')]"))
	WebElement homeNavigationButton;
	
	@FindBy(xpath = ("//a[contains(text(),'Cart')]"))
	WebElement cartNavigationButton;
	
	
	@FindBy(xpath = ("//a[text()='CATEGORIES']"))
	WebElement Homepage;
	
	@FindBy(xpath = ("//a[text()='Phones']"))
	WebElement PhoneCategory;
	
	@FindBy(xpath = ("//a[text()='Laptops']"))
	WebElement LaptopsCategory;
	
	@FindBy(xpath = ("//a[text()='Monitors']"))
	WebElement MonitorsCategory;
	
	
		
	
	
	
	
	
	
	public DashboardPage(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}

	
	public boolean VerifyHomePage(WebDriver driver) {
		waitUntilElementDisplayed(Homepage, driver);
		scrollIntoSpecificView(Homepage, driver);
		return isElementDisplayed(Homepage, driver);
	}
	
	public boolean verifyDeletedProductFromCart(String Product,WebDriver driver) {
		try {
			isElementDisplayed(driver.findElement(By.xpath("//td[text()='"+Product+"']//following-sibling::td//a[text()='Delete']")), driver);
			return true;
		}catch (Exception e) {
			return false;
		}
		
		
	}
	
	public void clickPhoneCategory(WebDriver driver) {
		waitUntilElementDisplayed(PhoneCategory, driver);
		click(PhoneCategory, driver);
	}
	public void deleteProductFromCart(String Product,WebDriver driver) {
		waitUntilElementDisplayed(driver.findElement(By.xpath("//td[text()='"+Product+"']//following-sibling::td//a[text()='Delete']")), driver);
		click(driver.findElement(By.xpath("//td[text()='"+Product+"']//following-sibling::td//a[text()='Delete']")), driver);
	}
	public void clickhomeNavigationButton(WebDriver driver) {
		waitUntilElementDisplayed(homeNavigationButton, driver);
		click(homeNavigationButton, driver);
	}
	public void clickcartNavigationButton(WebDriver driver) {
		waitUntilElementDisplayed(cartNavigationButton, driver);
		click(cartNavigationButton, driver);
	}
	
	
	public void clickLaptopsCategory(WebDriver driver) {
		waitUntilElementDisplayed(LaptopsCategory, driver);
		click(LaptopsCategory, driver);
	}
	public void clickMonitorsCategory(WebDriver driver) {
		waitUntilElementDisplayed(MonitorsCategory, driver);
		click(PhoneCategory, driver);
	}
	public void clickProduct(String product ,WebDriver driver) {
		waitUntilElementDisplayed(driver.findElement(By.xpath("//a[text()='"+product+"']")), driver);
		click(driver.findElement(By.xpath("//a[text()='"+product+"']")), driver);
	}
		
		
	

}
