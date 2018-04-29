package com_crm_qa_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_crm_qa_base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement loginbutton;
	@FindBy(xpath ="//img[contains(@class,'img-responsive')]" )
	
	WebElement crmlogo;
	@FindBy(xpath="//input[@type='submit'][@value='Login']")
	WebElement signUpBtn;
	
	// construct the constructor to initalize webelements
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateloginpagetitle()
	{
		return driver.getTitle();
	}
	public boolean crmlogo()
	{
		return crmlogo.isDisplayed();
	}
	public HomePage validatelogin(String un, String psw)
	{
		username.sendKeys(un);
		password.sendKeys(psw);
		System.out.println(loginbutton.isEnabled());
		System.out.println(loginbutton.isDisplayed());
		loginbutton.click();
		return new HomePage();
		
	}
	
}
