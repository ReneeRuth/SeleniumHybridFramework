package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.Reusables;

public class VerifyLoginPage {

	WebDriver driver;
	Reusables reuse;
	LoginPage login;
	HomePage home;
	
	@BeforeTest
	public void browserSetup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\91996\\Documents\\Selenium\\geckodriver-v0.26.0-win64(1)\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		reuse = new Reusables();
		driver.get(reuse.ReadProperties("URL"));
	}

	@Test
	public void verifyLoginPage() throws Exception {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		Thread.sleep(4000);
		login.forgotPassword(1, 0);
		Thread.sleep(4000);
		login.login(2, 0, 1);
		reuse.getScreenshot("InvalidCredentials - LoginPage", driver); 
		Thread.sleep(3000);
		login.login(1,0,1);
		reuse.getScreenshot("ValidCredentials - LoginPage", driver);
		home.timesheetCheck();
		reuse.getScreenshot("Timesheet Validation", driver);
	}
	}
