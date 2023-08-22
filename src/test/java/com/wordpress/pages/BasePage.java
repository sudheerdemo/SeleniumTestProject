package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage 
{
		public WebDriver driver;
		
		public BasePage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void click(WebElement e) {
			e.click();
		}
		
		public void click(By by) {
			driver.findElement(by);
		}
		
		
}
