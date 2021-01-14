package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeTest (alwaysRun = true)
	public void setUp(){
		//super.setup();
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(groups={ "regression" })
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}
	
	@Test(priority=2, enabled=false)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(loginPage.verifyName(), "Kiran Kumar","Name is not valid");
	}
	
		
	@AfterTest(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
