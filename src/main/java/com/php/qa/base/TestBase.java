package com.php.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.apache.log4j.Logger;
import com.php.qa.util.TestUtil;
import com.php.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriverWait wait;

	public TestBase() {
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("/Users/arunkrishnan/Applications/API/Java/PHPTravelsTest/src/main"
					+ "/java/com/php/qa/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browsername= prop.getProperty("browser");
		if(browsername.equals("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	        
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 5);
		driver.get(prop.getProperty("url"));
	}
	
}
