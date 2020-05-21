package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverUtils {
	WebDriver driver;
	
	public WebDriverUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterText(String locatorType, String locatorValue, String text) 
	{
		if(locatorType == "id")
		{
			driver.findElement(By.id(locatorValue)).sendKeys(text);
		}
		else if(locatorType == "xpath") {
			driver.findElement(By.xpath(locatorValue)).sendKeys(text);
		}
	}
	
	public void clickElement(String locatorType, String locatorValue) 
	{
		if(locatorType == "id")
		{
			driver.findElement(By.id(locatorValue)).click();
		}
		else if(locatorType == "xpath") {
			driver.findElement(By.xpath(locatorValue)).click();
		}
	}
}
