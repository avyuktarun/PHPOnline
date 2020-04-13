package com.php.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.php.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase{
	
	//PageFactory -OR
	
	@FindBy(name="username")	
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//div/div/a[1][contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[@alt='Login']")
	WebElement phplogo;
	
	public LoginPage() {
		//intialize elements with driver and this pointing to current class objects 
		PageFactory.initElements(driver, this);
	}
	@Step("Getting login page title step..")
	public String validateLoginPageTitle() {
			return driver.getTitle();
	}
	@Step("verify login logo step..")
	public boolean validatePHPLogo() {
		return phplogo.isDisplayed();
	}
	@Step("login with username: {0} and password: {1} step..")
	public HomePage login(String email, String pwd) {
		username.sendKeys(email);
		password.sendKeys(pwd);
		loginBtn.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));
		return new HomePage();
	}

}
