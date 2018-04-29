package com_crm_qa_util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Testutil 
{
	public static void takescreenshot(WebDriver driver, String screenshotname)  
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./Screenshorts"+ screenshotname +".png"));
		} catch (IOException e) 
		{
			System.out.println("Exception are" + e.getMessage());
			e.printStackTrace();
		}
				
			System.out.println("screenshot taken");
			
			
	}

}
