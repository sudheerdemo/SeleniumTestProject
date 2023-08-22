package com.wordpress.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.pages.DashBoardPage;
import com.wordpress.pages.HomePage;
import com.wordpress.pages.LoginPage;
import com.wordpress.pages.ProfilePage;

public class ProfileTest extends BaseTest
{

	HomePage hPage;
	LoginPage lPage;
	DashBoardPage dPage;
	ProfilePage pPage;
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		hPage = new HomePage(driver);
		lPage = PageFactory.initElements(driver, LoginPage.class);
		dPage = new DashBoardPage(driver);
		pPage = new ProfilePage(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	@Test
	public void testUpdateProfileWithValidDetails() throws InterruptedException
	{
		//login
		hPage.clickOnLoginLink();
		lPage.setUserName("sudheerkumar.gv@gmail.com");
		lPage.clickOnContinueButton();
		lPage.setPassword("kumar@123");
		lPage.clickOnLoginButton();	
		Thread.sleep(3*1000);
		//click on profile icon
		dPage.clickOnProfileIcon();
		//In Profile Page
		pPage.setFirstName("Shashidhar");
		pPage.setLastName("Jakku");
		pPage.setDisplayName("Mr.");
		pPage.setAboutMe("Selenium Student"+System.currentTimeMillis());
		pPage.clickOnSaveButton();
	}
}
