package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	Reusables reuse;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		reuse = new Reusables();

	}

	public void login(int row, int col_user, int col_pass)
	{
		driver.findElement(By.id(reuse.ReadProperties("UsernameLocator"))).sendKeys(reuse.excelRead(row,col_user));
		driver.findElement(By.id(reuse.ReadProperties("PasswordLocator"))).sendKeys(reuse.excelRead(row,col_pass));
		driver.findElement(By.id(reuse.ReadProperties("LoginButton"))).click();
	}
	
	public void forgotPassword(int row, int col_user) throws Exception
	{
		driver.findElement(By.xpath(reuse.ReadProperties("forgotPassword"))).click();
		driver.findElement(By.id(reuse.ReadProperties("forgotPasswordUsername"))).sendKeys(reuse.excelRead(row, col_user));
		Thread.sleep(3000);
		driver.findElement(By.id(reuse.ReadProperties("resetCancelButton"))).click();	
	}
}
