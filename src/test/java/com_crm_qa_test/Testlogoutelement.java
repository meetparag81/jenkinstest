package com_crm_qa_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testlogoutelement
{
	 static WebDriver driver;

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","G:\\Javaprogramming\\Selenium\\Selenium Setup\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("https://www.freecrm.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("meetparag81");
		driver.findElement(By.name("password")).sendKeys("pBorprg$81");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement login = driver.findElement(By.xpath("//input[@class= 'btn btn-small'][@value='Login']"));
		 WebElement element= wait.until(ExpectedConditions.elementToBeClickable(login));
		element.click();
		driver.findElement(By.xpath("//a[@title= 'Contacts']")).click();

	}

}
