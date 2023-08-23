package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage 
{

	private WebDriver driver;
	
	@FindBy(how=How.ID, using="usernameOrEmail")
	WebElement userNameElement;
	
	
	@FindBy(how=How.XPATH, using="//button[text()='Continue']")
	WebElement ContinueButtonElement;
	
	
	@FindBy(how=How.ID, using="password")
	WebElement passwordElement;
	
	
	@FindBy(how=How.XPATH, using="//button[text()='Log In']")
	WebElement loginButtonElement;
	
	@FindBy(how=How.XPATH,using="//span[text()='User does not exist.']")
	WebElement errorMessageUsrNotExistsElement;
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean isUserNameElementExists()
	{
		return userNameElement.isDisplayed();
	}
	
	public void setUserName(String userName)
	{
		userNameElement.clear();
		userNameElement.sendKeys(userName);
	}
	
	public void clickOnContinueButton()
	{
		ContinueButtonElement.click();
		try {
			Thread.sleep(3*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void setPassword(String password)
	{
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}
	
	
	public void clickOnLoginButton()
	{
		loginButtonElement.click();
	}
	
	public String getUserNotExistsErrorMsg()
	{
		return errorMessageUsrNotExistsElement.getText().trim();
	}
	
	
}
