package session10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Configuration;

public class Activity5_NavigatetoMyAcc {
	
	private WebDriver driver = null;
	@BeforeTest
	public void BrowserLaunch() throws InterruptedException {
		
		driver= Configuration.createFireFoxDriver();
		driver.get(Configuration.JobBoard_Url);
		Thread.sleep(5000);
	}
	
	@Test
	public void NavigatetoAccount() throws InterruptedException {
		
		WebElement GetLink= driver.findElement(By.partialLinkText("My Account"));
		GetLink.click();
		Thread.sleep(5000);
		String NewPageTitle=driver.getTitle();
		System.out.println("New Page Title is : " + NewPageTitle);
		Assert.assertEquals(NewPageTitle, "My Account – Alchemy LMS");
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
  

}
