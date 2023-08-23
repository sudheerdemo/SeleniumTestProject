package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage
{
	
	WebDriver driver;
	public ProfilePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setFirstName(String firstName)
	{
		WebElement firstNameElement = driver.findElement(By.id("first_name"));
		firstNameElement.clear();
		firstNameElement.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		WebElement lastNameElement = driver.findElement(By.id("last_name"));
		lastNameElement.clear();
		lastNameElement.sendKeys(lastName);
	}
	
	
	public void setDisplayName(String displayName)
	{
		WebElement displayNameElement = driver.findElement(By.id("display_name"));
		displayNameElement.clear();
		displayNameElement.sendKeys(displayName);
	}
	
	public void setAboutMe(String aboutMe)
	{
		WebElement descriptionElement = driver.findElement(By.id("description"));
		descriptionElement.clear();
		descriptionElement.sendKeys(aboutMe);
	}
	
	
	public void clickOnSaveButton()
	{
		WebElement saveProfileDetailsElement = driver.findElement(By.xpath("//button[text()='Save profile details']"));
		saveProfileDetailsElement.click();
	}
}
