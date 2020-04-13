package com.php.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.php.qa.base.TestBase;

public class VisaPage extends TestBase {
//	@FindBy(xpath="//div[@id='mobileMenuMain']//a[contains(text(),'Visa')]")
//	WebElement visalink;
	@FindBy(xpath="(//a[@class='chosen-single']//div)[4])")
	WebElement fromCountry;
	@FindBy(xpath="(//a[@class='chosen-single']//div)[5])")
	WebElement toCountry;
	@FindBy(xpath="//input[@placeholder='Date']")
	WebElement date;
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement btnSubmit;
	@FindBy(xpath="//a[contains(text(),'Visa Booking')]")
	WebElement label;

	//Initialzing the Page Objects
	
	public VisaPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyVisaPageTitle() {
	return driver.getTitle();
	}
	
	public void selectVisa(String from, String to ) {
		Select origin = new Select(driver.findElement(By.name("nationality_country")));  
		origin.selectByVisibleText(from);  

		//origin.click();
		Select destination = new Select(driver.findElement(By.name("destination_country")));  
		destination.selectByVisibleText(to); 
		//destination.click();
		WebElement selectDate = driver.findElement(By.xpath(""));
	    selectDate.click();
		//date.sendKeys(dates);
		btnSubmit.click();		
	}
	public boolean verifyLabel() {
		return label.isDisplayed();
	}

}
