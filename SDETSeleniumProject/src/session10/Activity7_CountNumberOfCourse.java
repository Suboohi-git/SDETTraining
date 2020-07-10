package session10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Configuration;

public class Activity7_CountNumberOfCourse {
	
	private WebDriver driver = null;
	
	@BeforeTest
	public void BrowserLaunch() throws InterruptedException {
		
		driver= Configuration.createFireFoxDriver();
		driver.get(Configuration.JobBoard_Url);
		
	}
	
	@Test
	public void GetTotalCourse() throws InterruptedException {
		
		WebElement GetLink= driver.findElement(By.partialLinkText("All Courses"));
		GetLink.click();
		
		List<WebElement> Courses= driver.findElements(By.className("caption"));
		System.out.println("Total number of course is : "+ Courses.size());
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
  
}
