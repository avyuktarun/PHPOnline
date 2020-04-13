package com.php.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.php.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//h3[contains(text(),'Hi, Demo User')]")
	WebElement userLabel; 
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement homelink;
	
	@FindBy(xpath="//div[@id='mobileMenuMain']//a[contains(text(),'company')]")
	WebElement companyLink;
	
	@FindBy(xpath="//div[@id='mobileMenuMain']//a[contains(text(),'Visa')]")
	WebElement visalink;
	
	//Initialzing the Page Objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyuserLabel() {
		return userLabel.isDisplayed();
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public HomePage verifyHomeLink() {
		homelink.click();
		return new HomePage();
		//return driver.getTitle();
	}
	
	public VisaPage verifyVisaLink() {
		visalink.click();
		return new VisaPage();
	}
	
	public ContactPage clickContactLink() {
		Actions actions = new Actions(driver);
		actions.moveToElement(companyLink);
		WebElement subMenu = driver.findElement(By.xpath("//div[@id='mobileMenuMain']//a[contains(text(),'Contact')]"));
		actions.moveToElement(subMenu).click().build().perform();;
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='mobileMenuMain']//a[contains(text(),'Contact')]")));
		//actions.click().build().perform();
		return new ContactPage();
		//ul[@style='display: block;']//a[contains(text(),'Contact')]

	}

}
