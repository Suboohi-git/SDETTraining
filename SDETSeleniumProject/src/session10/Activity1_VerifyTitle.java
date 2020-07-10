package session10;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Configuration;

public class Activity1_VerifyTitle {
	
	private WebDriver driver = null;
	
	@BeforeTest
	public void BrowserLaunch() throws InterruptedException {
		
		driver= Configuration.createFireFoxDriver();
		driver.get(Configuration.JobBoard_Url);
		Thread.sleep(5000);
	}
	
	@Test
	public void VerifyTitle() {
		
		String JobHomePageTitle=driver.getTitle();
		Assert.assertEquals(JobHomePageTitle, "Alchemy LMS – An LMS Application ");
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
	
	
}
