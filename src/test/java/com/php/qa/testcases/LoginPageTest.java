package com.php.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.php.qa.base.TestBase;
import com.php.qa.pages.HomePage;
import com.php.qa.pages.LoginPage;
import com.qa.ExtentReportListener.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({TestAllureListener.class})
public class LoginPageTest extends TestBase{
	
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
		
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		log.info("****************************** Starting test cases execution  *****************************************");
		initialization();
		 loginPage =  new LoginPage();
		 log.info("entering application URL");
			log.warn("Hey this just a warning message");
			log.fatal("hey this is just fatal error message");
			log.debug("this is debug message");
	}
	
	@Test(priority=1, description ="Verifying login page title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case for login page title test")
	@Story("Story Name: To check login page")
	public void loginPageTitleTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** PHPTitleTest *****************************************");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Login");
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** PHPTitleTest *****************************************");
	}
	
	@Test(priority=2, description= "verify logo image")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case for logo image test")
	@Story("Story Name: To check login image")
	public void PHPLogoImageTest() {
		boolean flag= loginPage.validatePHPLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3, description = "login with correct credentials")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case for login credentials")
	@Story("Story Name: To check login credetials")
	public void loginTest() {
		homePage= loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Assert.assertEquals(homePage.verifyHomePageTitle(), "My Account","Home page title didn't matched");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}
	

}
