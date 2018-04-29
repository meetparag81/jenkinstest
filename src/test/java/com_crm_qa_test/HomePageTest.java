package com_crm_qa_test;
//test
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com_crm_qa_base.TestBase;
import com_crm_qa_pages.Contactspage;
import com_crm_qa_pages.HomePage;
import com_crm_qa_pages.LoginPage;
import com_crm_qa_util.Test_Util;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	Test_Util testUtil;
	Contactspage contactsPage;
	 public HomePageTest()
	{
		 super();
	
	}
		
	 @BeforeMethod
		public void setUp()
	 {
			
			
			TestBase.initalization();
			testUtil = new Test_Util();
			contactsPage = new Contactspage();
			loginPage = new LoginPage();
			homePage = loginPage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		
		@Test(priority=1)
		public void verifyHomePageTitleTest(){
			String homePageTitle = homePage.verifyHomepagetitle();
			//Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
		}
		
		@Test(priority=2)
		public void verifyUserNameTest(){
			testUtil.switchToFrame();
			Assert.assertTrue(homePage.verifycorrectusername());
		}
		
		@Test(priority=3)
		public void verifyContactsLinkTest(){
			testUtil.switchToFrame();
			contactsPage = homePage.clickOnContactsLinks();
		}
		
		
		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		
	}
}

	

