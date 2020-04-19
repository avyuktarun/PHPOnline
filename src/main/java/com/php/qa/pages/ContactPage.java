package com.php.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.php.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath="(//span[contains(text(),'Name')])")
	WebElement namefield;
	@FindBy(xpath="(//input[@id='form_email']")
	WebElement emailfield;
	@FindBy(xpath="//input[@id='form_subject']")
	WebElement subjectfield;
	@FindBy(xpath="//textarea[@id='form_message']")
	WebElement messagefield;
	@FindBy(xpath="//span[@id='recaptcha-anchor']//div[1]")
	WebElement captchacheckbox;
	@FindBy(xpath="//input[@name='submit_contact']")
	WebElement submitbtn;
	@FindBy(className ="contact-successful-messages")
	WebElement successMessage;
	
	// Initialzing the Page Objects

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyContactPageTitle() {
		return driver.getTitle();
	}
	public void enterContactDetails(String name, String email,String subject, String message ) {
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//span[contains(text(),'Name')])"))).clear();
		namefield.sendKeys(name);
		emailfield.sendKeys(email);
		subjectfield.sendKeys(subject);
		messagefield.sendKeys(message);
		captchacheckbox.click();
		submitbtn.click();
	}
	public boolean verifySuccessMessage() {
		return successMessage.isDisplayed();
	}
}
