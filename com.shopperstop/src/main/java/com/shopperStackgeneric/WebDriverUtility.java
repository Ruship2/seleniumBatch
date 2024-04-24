package com.shopperStackgeneric;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	Select sel;
	File temp;
	File dest;
	WebDriver driver;
	JavaUtility ju=new JavaUtility();

	public void selectByValue(WebElement element, String Value) {
		sel = new Select(element);
		sel.selectByValue(Value);
	}
	public void selectByIndex(WebElement element,int index) {
		sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void selectByVisibleText(WebElement element,String text) {
		sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void deselectByValue(WebElement element,String value) {
		sel=new Select(element);
		sel.deselectByValue(value);
	}
	public void deselectByIndex(WebElement element,int index) {
		sel=new Select(element);
		sel.deselectByIndex(index);
	}
	public void deselectByVisibleText(WebElement element,String text) {
		sel=new Select(element);
		sel.deselectByVisibleText(text);
	}
	public void deselectAll(WebElement element) {
		sel=new Select(element);
		sel.deselectAll();
	}
	public void screenShotWebPage() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		temp = ts.getScreenshotAs(OutputType.FILE);
		dest = new File(FrameworkContants.screenShot+ju.localDateTime()+".png");
		FileHandler.copy(temp, dest);

	}

	public void screenShotWebElement(WebElement element) throws IOException {
		temp = element.getScreenshotAs(OutputType.FILE);
		dest = new File(FrameworkContants.screenShot+ju.localDateTime()+".png");
		FileHandler.copy(temp, dest);

	}
}
