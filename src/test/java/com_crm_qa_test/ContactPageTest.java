package com_crm_qa_test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_crm_qa_base.TestBase;
import com_crm_qa_pages.Contactspage;
import com_crm_qa_pages.HomePage;
import com_crm_qa_pages.LoginPage;
import com_crm_qa_util.Test_Util;

public class ContactPageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	Test_Util testUtil;
	Contactspage contactsPage;
	
	String sheetName = "contacts";
	
	   
	public ContactPageTest()
	{
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		TestBase.initalization();
		testUtil = new Test_Util();
		contactsPage = new Contactspage();
		loginPage = new LoginPage();
		homePage = loginPage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
		
		contactsPage = homePage.clickOnContactsLinks();//This method returns contactpage object
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=3)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
	}
	
	@Test(priority=4)
	public void selectMultipleContactsTest()
	{
		testUtil.switchToFrame();// to click on contacts needs switch to frame and then click on contacts link
		homePage.clickOnContactsLinks();
		contactsPage.selectContactsByName("test2 test2");
		contactsPage.selectContactsByName("ui uiii");

	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = Test_Util.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company)
	{
		homePage.clickOnContactsLinks();
		contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		//contactsPage.createNewContact(title, firstName, lastName, company);

	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
