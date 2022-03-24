package com.shop.pages;


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
	WebElement homepage;
	
	@FindBy(xpath = ("//a[text()='Phones']"))
	WebElement phoneCategory;
	
	@FindBy(xpath = ("//a[text()='Laptops']"))
	WebElement laptopsCategory;
	
	@FindBy(xpath = ("//a[text()='Monitors']"))
	WebElement monitorsCategory;
	

	public DashboardPage(WebDriver driverParam) {
		this.podriver = driverParam;
		PageFactory.initElements(this.podriver, this);
	}

	
	public boolean verifyHomePage(WebDriver driver) {
		waitUntilElementDisplayed(homepage, driver);
		scrollIntoSpecificView(homepage, driver);
		return isElementDisplayed(homepage, driver);
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
		click(phoneCategory, driver);
	}
	public void deleteProductFromCart(String Product,WebDriver driver) {
		click(driver.findElement(By.xpath("//td[text()='"+Product+"']//following-sibling::td//a[text()='Delete']")), driver);
	}
	public void clickHomeNavigationButton(WebDriver driver) {
		click(homeNavigationButton, driver);
	}
	public void clickCartNavigationButton(WebDriver driver) {
		click(cartNavigationButton, driver);
	}
	
	
	public void clickLaptopsCategory(WebDriver driver) {
		click(laptopsCategory, driver);
	}
	public void clickMonitorsCategory(WebDriver driver) {
		click(phoneCategory, driver);
	}
	public void clickProduct(String product ,WebDriver driver) {
		click(driver.findElement(By.xpath("//a[text()='"+product+"']")), driver);
	}
		
		
	

}
