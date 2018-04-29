package com_crm_qa_util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com_crm_qa_base.TestBase;

public class Test_Util extends TestBase implements ITestListener 
{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH = "G:\\Javaprogramming\\Maven5\\src\\main\\java\\com_crm_qa_data\\FreeCrmTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static Object[][] getTestData(String sheetName) 
	{
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	public static void takescreenshot(WebDriver driver, String screenshotname) throws Exception  
	{
		/*TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(source, new File(currentDir + "/screenshots/" + screenshotname + ".png"));*/
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshotsfail/" + screenshotname + ".png"));
		
		
	//	System.out.println("screenshot taken");
	}
	
	
		


	public void onFinish(ITestContext result) 
	{
		// TODO Auto-generated method stub
		
	}


	public void onStart(ITestContext result) 
	{
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}


	public void onTestFailure(ITestResult result)
	{
		if(ITestResult.FAILURE ==result.getStatus() )
			Testutil.takescreenshot(driver, result.getName());
		
	}


	public void onTestSkipped(ITestResult result) 
	{
		if(ITestResult.SKIP ==result.getStatus() )
			Testutil.takescreenshot(driver, result.getName());
		
	}


	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	public static void takeScreenshotAtEndOfTest() throws Exception 
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
	
	
	}

	

