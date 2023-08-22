package com.wordpress.tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.wordpress.constants.Constants;
import com.wordpress.utils.ReadProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements Constants
{
			WebDriver driver;
			ReadProperties configProp;

			
			@Parameters({ "browser" })
			@BeforeMethod
			public void beforeMethodAtBase(@Optional(BROWSER_CHROME)String browser) throws InterruptedException
			{
				
				configProp = new ReadProperties("./src/test/resources/config.properties");
				String chrome_driver_path=configProp.getPropertyValue("chrome_driver_path");
				String gecko_driver_path=configProp.getPropertyValue("gecko_driver_path");
				String url=configProp.getPropertyValue("url");
				
				if(browser.equalsIgnoreCase(BROWSER_CHROME))
				{
					System.setProperty(PROPERTY_WEBDRIVER_CHROME, chrome_driver_path);
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
					driver = new ChromeDriver(options);   //opens the browser
				}
				else if(browser.equalsIgnoreCase(BROWSER_FIREFOX))
				{
					System.setProperty(PROPERTY_WEBDRIVER_GECKO, gecko_driver_path);
					driver = new FirefoxDriver();
				}
				
				
				driver.get(url);   //load the url
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.manage().window().maximize();    //to maximize the window
				Thread.sleep(5*1000);
				
				
			}
}
