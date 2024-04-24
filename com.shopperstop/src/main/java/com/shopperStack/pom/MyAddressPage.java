package com.shopperStack.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressPage {

	public MyAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressBtn;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiButton-startIcon')])[2]")
	public WebElement getDeleteBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	public WebElement getYesBtn;
	
	public WebElement getGetYesBtn() {
		return getYesBtn;
	}

	public WebElement getGetDeleteBtn() {
		return getDeleteBtn;
	}

	public WebElement getAddAddressBtn() {
		return addAddressBtn;
	}
	
	
	
}
