package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage 
{
		WebDriver driver;
		
		public HomePage(WebDriver driver)
		{
			this.driver = driver;
		}
		
		
		public void clickOnLoginLink() throws InterruptedException
		{
			WebElement Login = driver.findElement(By.linkText("Log In"));
			Login.click();
			Thread.sleep(3*1000);
		}
}
