package com.wordpress.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage extends BasePage {

	
	public DashBoardPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnProfileIcon()
	{
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Me']")));
		click(element);
	}
	
	public void click(WebElement e) {
		super.click(e);
	}
}
