package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	Reusables reuse;
	
 public HomePage(WebDriver driver)
 {
	 this.driver = driver;
 }
 
 public void timesheetCheck() throws Exception
 {
	 reuse = new Reusables();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(reuse.ReadProperties("timesheetIcon"))).click();
	 Thread.sleep(5000);
	 driver.findElement(By.id(reuse.ReadProperties("empNameID"))).click();
	 driver.findElement(By.id(reuse.ReadProperties("empNameID"))).sendKeys("John Smith");
	 driver.findElement(By.id(reuse.ReadProperties("viewButtonID"))).click();
			 
 }

}
