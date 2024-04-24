package com.shopperStackgeneric;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersUtility implements ITestListener,ISuiteListener{

	JavaUtility ju=new JavaUtility();
	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot) BaseTest.listenerDriver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(FrameworkContants.screenShot+ju.localDateTime()+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
