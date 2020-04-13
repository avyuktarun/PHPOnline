package com.php.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.php.qa.base.TestBase;
import com.php.qa.pages.ContactPage;
import com.php.qa.pages.HomePage;
import com.php.qa.pages.LoginPage;
import com.php.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	
	String sheetName = "Contacts";

	public ContactPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		 loginPage =  new LoginPage();
		 contactPage =  new ContactPage();
		 //homePage = new HomePage();
		 homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getPHPContactTestData() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getPHPContactTestData")
	public void createContactTest(String name, String email,String subject, String message) {
		contactPage = homePage.clickContactLink();
		String title= contactPage.verifyContactPageTitle();
		Assert.assertEquals(title, "Contact", "Page title not matched");
		//visaPage.selectVisa("India","France","20-04-2020");
		contactPage.enterContactDetails(name,email,subject,message);
		Assert.assertTrue(contactPage.verifySuccessMessage());
	}
	
	@AfterMethod
	public void tearDown( ) {
		//driver.quit();
	}

}
