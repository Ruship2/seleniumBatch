package com.shopperstop_TestScript;

import org.testng.annotations.Test;

import com.shopperStack.pom.MyAddressPage;
import com.shopperStack.pom.MyProfilePage;
import com.shopperStackgeneric.BaseTest;

public class check_user_can_delete_the_Address_Test extends BaseTest {

	@Test
	public void deleteAddress() throws InterruptedException {
		
		homePage.getAccountBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfilePage myProfile=new MyProfilePage(driver);
		myProfile.getMyAddressBtn().click();
		
		MyAddressPage myAddress=new MyAddressPage(driver);
		Thread.sleep(2000);
		myAddress.getDeleteBtn.click();
		Thread.sleep(2000);
		myAddress.getYesBtn.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
}
