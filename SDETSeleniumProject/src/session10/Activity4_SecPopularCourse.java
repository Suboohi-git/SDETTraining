package session10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Configuration;

public class Activity4_SecPopularCourse {
	
	private WebDriver driver = null;
	@BeforeTest
	public void BrowserLaunch() throws InterruptedException {
		
		driver= Configuration.createFireFoxDriver();
		driver.get(Configuration.JobBoard_Url);
		Thread.sleep(5000);
	}
	
	@Test
	public void VerifySecPopularCourse() {
		
		List<WebElement> PopularCourse=driver.findElements(By.className("entry-title"));
		System.out.println("This is the second course: "+  PopularCourse.get(1).getText());
		String SecondPopular=PopularCourse.get(1).getText();
		Assert.assertEquals(SecondPopular, "Email Marketing Strategies");
		
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
  

}
