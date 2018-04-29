package com_crm_qa_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_crm_qa_base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath = "//td[contains(text(),'User: Parag Borawake')]")
	
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@title= 'Contacts']")
			// "//*[@id='navmenu']/ul/li[4]/a")
	
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Contactspage clickOnContactsLinks()
	{
		contactsLink.click();
		return new Contactspage();
	}
	
	public Dealsspage clickOnDealslinktest()
	{
		dealsLink.click();
		return new Dealsspage();
	}
	public Taskpage clickOnTaskslinktest()
	{
		dealsLink.click();
		return new Taskpage();
	}

	public String verifyHomepagetitle() 
	{
		
		return driver.getTitle();
	}
	public boolean verifycorrectusername()
	{
		return userNameLabel.isDisplayed();
	}
	
	public void clickonnewlink()
	{
		Actions act = new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
}
	


