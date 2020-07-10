package session10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Configuration;

public class Activity2_VerifyHeading {
	
private WebDriver driver = null;
	
	@BeforeTest
	public void BrowserLaunch() throws InterruptedException {
		
		driver= Configuration.createFireFoxDriver();
		driver.get(Configuration.JobBoard_Url);
		Thread.sleep(5000);
	}
	
	@Test
	public void VerifyHeading() {
		
		//WebElement JobHomePageHeading= driver.findElement(By.xpath("//div[contains(@class,'uagb-ifb-title')]/h1"));
		WebElement JobHomePage= driver.findElement(By.className("uagb-ifb-title"));
		System.out.println("This is the actual heading: "+  JobHomePage.getText());
		String JobHomePageHeading=JobHomePage.getText();
		Assert.assertEquals(JobHomePageHeading, "Learn from Industry Experts");
		
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
  
}
