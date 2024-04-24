package com.shopperstop_TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.shopperStack.pom.AddAddressPage;
import com.shopperStack.pom.HomePage;
import com.shopperStack.pom.LoginPage;
import com.shopperStack.pom.MyAddressPage;
import com.shopperStack.pom.MyProfilePage;
import com.shopperStack.pom.WelcomePage;
import com.shopperStackgeneric.BaseTest;
import com.shopperStackgeneric.WebDriverUtility;

public class check_user_can_Add_the_AddressTest extends BaseTest {

	@Test
	public void addAddress() throws IOException, InterruptedException {
		
		homePage.getAccountBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfilePage myProfile=new MyProfilePage(driver);
		myProfile.getMyAddressBtn().click();
		
		MyAddressPage myAddress=new MyAddressPage(driver);
		myAddress.getAddAddressBtn().click();
		
		AddAddressPage addAddress=new AddAddressPage(driver);
		addAddress.getAddressType().click();
		addAddress.getNameField().sendKeys(fu.readExcelData("sheet1", 1, 0));
		addAddress.getOfficeInfoField().sendKeys(fu.readExcelData("sheet1", 1, 1));
		addAddress.getStreetInfoField().sendKeys(fu.readExcelData("sheet1", 1, 2));
		addAddress.getLandmarkField().sendKeys(fu.readExcelData("sheet1", 1, 3));
		
		webdriverUtility.selectByValue(addAddress.getCountryField(), fu.readPropertyData("country"));
		webdriverUtility.selectByValue(addAddress.getStateField(), fu.readPropertyData("state"));
		webdriverUtility.selectByValue(addAddress.getCityField(), fu.readPropertyData("city"));
		
		addAddress.getPincodeField().sendKeys(fu.readExcelData("sheet1", 1, 4));
		addAddress.getPhoneNumberField().sendKeys(fu.readExcelData("sheet1", 1, 5));
		addAddress.getAddAddressBtn().click();
		
	}
}
