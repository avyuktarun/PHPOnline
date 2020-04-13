package com.php.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.php.qa.base.TestBase;
import com.php.qa.pages.HomePage;
import com.php.qa.pages.LoginPage;
import com.php.qa.pages.VisaPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	VisaPage visaPage;

	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		 loginPage =  new LoginPage();
		 visaPage =  new VisaPage();
		 //homePage = new HomePage();
		 homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		 
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title= homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "My Account","Home page title didn't matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyuserLabel());
	}
	
	@Test(priority=3)
	public void verifyHomeLinkTest() {
		homePage= homePage.verifyHomeLink();
	}
	@Test(priority=4)
	public void verifyVisaLinkTest() {
		visaPage = homePage.verifyVisaLink();
	}
	
	@AfterMethod
	public void tearDown( ) {
		driver.quit();
	}

}
