package com.shopperStackgeneric;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.shopperStack.pom.HomePage;
import com.shopperStack.pom.LoginPage;
import com.shopperStack.pom.WelcomePage;

public class BaseTest {

	public WebDriver driver;
	public static WebDriver listenerDriver;
	public FileUtility fu=new FileUtility();
	public WebDriverUtility webdriverUtility=new WebDriverUtility();
	public HomePage homePage;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public JavaUtility java=new JavaUtility();
	@BeforeSuite
	public void bs() {
		System.out.println("Before Suite");
		spark=new ExtentSparkReporter("./Reports/"+java.localDateTime()+".html");
	}
	@BeforeTest
	public void bt() {
		System.out.println("Before Test");
//		report=new ExtentReports();
//		report.attachReporter(spark);
//		test=report.createTest("Demo");
	}
	@BeforeClass
	public void bc() throws IOException {
		System.out.println("Before Class");
//		String url = fu.readPropertyData("url");
//		String browser = fu.readPropertyData("browser");
		
		String url = System.getProperty("url");
		String browser = System.getProperty("browser");
		
		if (browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if (browser.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			System.out.println("provide valid browser");
		}
		listenerDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get(url);
//		test.log(Status.INFO, "Navigated....!");
		homePage=new HomePage(driver);
		
	}
	@BeforeMethod
	public void bm() throws IOException, InterruptedException {
		System.out.println("Before Method");
		
		WelcomePage welcomePage=new WelcomePage(driver);
		Thread.sleep(2000);
		welcomePage.getLoginButton().click();
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmailTextField().sendKeys(fu.readPropertyData("email"));
		loginPage.getPasswardTextField().sendKeys(fu.readPropertyData("pwd"));
		loginPage.getLoginButton().click();
//		test.log(Status.INFO, "login success");
	}
	@AfterMethod
	public void am() throws InterruptedException {
		System.out.println("After Method ");
		homePage.getAccountBtn().click();
		Thread.sleep(1000);
		homePage.getLogoutBtn().click();
//		test.log(Status.INFO, "logout success");
	}
	@AfterClass
	public void ac() throws InterruptedException {
		System.out.println("After Class");
		Thread.sleep(3000);
		driver.quit();
	}
	@AfterTest
	public void at() {
		System.out.println("After Test");
//		report.flush();
	}
	@AfterSuite
	public void as() {
		System.out.println("After Suite");
	}
	
	
	
}
