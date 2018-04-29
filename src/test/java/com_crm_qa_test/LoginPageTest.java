package com_crm_qa_test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com_crm_qa_base.TestBase;
import com_crm_qa_pages.HomePage;
import com_crm_qa_pages.LoginPage;

public class LoginPageTest extends TestBase 
{
	LoginPage LoginPage;
	HomePage homePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		TestBase.initalization();
		LoginPage = new LoginPage();
		
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = LoginPage.validateloginpagetitle();
		System.out.println(title);
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = LoginPage.crmlogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homePage = LoginPage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}






}
