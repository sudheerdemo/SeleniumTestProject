package com.wordpress.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.pages.HomePage;
import com.wordpress.pages.LoginPage;
import com.wordpress.utils.ExcelUtil;

public class LoginTest  extends BaseTest
{		
		HomePage hPage;
		LoginPage lPage;
		
		@BeforeMethod
		public void setUp() throws InterruptedException
		{		
			hPage = new HomePage(driver);
			lPage = PageFactory.initElements(driver, LoginPage.class); //if its page factory
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.close();
		}
	
		@Test
		public void testLoginWithValidCredentials() throws InterruptedException {
			hPage.clickOnLoginLink();
			lPage.setUserName("sudheerkumar.gv@gmail.com");
			lPage.clickOnContinueButton();
			lPage.setPassword("sudheer@321");
			lPage.clickOnLoginButton();
		}
		
		
		@Test
		public void testLoginWithInValidUserNames() throws InterruptedException {
			ExcelUtil eUtil = new ExcelUtil("./src/test/resources/Login.xls", 0);
			int size = eUtil.getNumberOfRows();
			
			for (int i =1;i<=size;i++)
			{
				
				String userName = eUtil.getCellValue(i,0 );
				String errorMessage = eUtil.getCellValue(i,1 );
				if(userName == null)
					break;
				
				if(errorMessage == null)
					break;
				
				if(userName.equalsIgnoreCase("") &&  errorMessage.equalsIgnoreCase(""))
					break;
				
				driver.get("https://wordpress.com/");
				hPage.clickOnLoginLink();
				lPage.setUserName(userName);
				lPage.clickOnContinueButton();
				String actualErrorMessage = lPage.getUserNotExistsErrorMsg();
				Assert.assertTrue(actualErrorMessage.contains(errorMessage));
				
			}
			
			
		}
		
		
//		@Test
//		public void testLoginWithInValidUserName_WithSplChars() throws InterruptedException {
//			hPage.clickOnLoginLink();
//			lPage.setUserName("#@$#$#%$^%");
//			lPage.clickOnContinueButton();
//		}
//		
//		
//		@Test
//		public void testLoginWithInValidUserName_withMixedChars() throws InterruptedException {
//			hPage.clickOnLoginLink();
//			lPage.setUserName("43545FD$#%$#");
//			lPage.clickOnContinueButton();
//		}
//		
		
}
