package com.php.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.php.qa.base.TestBase;
import com.php.qa.pages.HomePage;
import com.php.qa.pages.LoginPage;
import com.php.qa.pages.VisaPage;
import com.php.qa.util.TestUtil;

public class VisaPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	VisaPage visaPage;
	
	String sheetName = "Visa";

	public VisaPageTest() {
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
	
//	@Test(priority=1)
//	public void verifyVisaPageClickedTest() {
//		visaPage = homePage.verifyVisaLink();
//		String title= visaPage.verifyVisaPageTitle();
//		Assert.assertEquals(title, "PHPTRAVELS | Travel Technology Partner", "Visa title not matched");
//	}
	@DataProvider
	public Object[][] getPHPTestData() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getPHPTestData")
	public void selectVisaTest(String from, String to) {
		visaPage = homePage.verifyVisaLink();
		String title= visaPage.verifyVisaPageTitle();
		Assert.assertEquals(title, "PHPTRAVELS | Travel Technology Partner", "Visa title not matched");
		//visaPage.selectVisa("India","France","20-04-2020");
		visaPage.selectVisa(from,to);
		Assert.assertTrue(visaPage.verifyLabel());

	}
	
	@AfterMethod
	public void tearDown( ) {
		driver.quit();
	}
	
}
