package com.wordpress.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakeScreenShotEx {
	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		try
		{
			System.setProperty("webdriver.chrome.driver", "/Users/test/selenium/chrome_245/chromedriver");
			driver = new ChromeDriver();   //opens the browser
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.mortgagecalculator.org/");
			
			WebElement homeAmtElement = driver.findElement(By.name("param[homevalue111]"));
			homeAmtElement.clear();
			homeAmtElement.sendKeys("10000");

			WebElement loandAmt = driver.findElement(By.id("loanamt44444"));
			loandAmt.clear();
			loandAmt.sendKeys("10000");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("main1111112233.png"));
		}

	}

}
