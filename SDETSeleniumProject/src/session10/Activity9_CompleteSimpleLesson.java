package session10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Configuration;

public class Activity9_CompleteSimpleLesson {
	
private WebDriver driver = null;
private WebDriverWait wait= null;
	
	@BeforeTest
	public void BrowserLaunch() throws InterruptedException {
		
		driver= Configuration.createFireFoxDriver();
		wait= new WebDriverWait(driver, 60);
		driver.get(Configuration.JobBoard_Url);
		
	}
	
	@Test
	public void CompleteCourse() throws InterruptedException {
		
		WebElement GetLink= driver.findElement(By.partialLinkText("All Courses"));
		GetLink.click();
		
		List<WebElement> CoursesList=driver.findElements(By.className("entry-title"));
		String SecondCourse=CoursesList.get(1).getText();
		System.out.println("Course Name: "+ SecondCourse);
		Assert.assertEquals(SecondCourse, "Email Marketing Strategies");
		
		
		List<WebElement> CourseListSeeMore= driver.findElements(By.xpath("//a[contains(@class,'btn btn-primary')]"));
		CourseListSeeMore.get(1).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ld-button"))).click();
		
		// Entering username and login
		
		WebElement UserNametype= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
		UserNametype.sendKeys(Configuration.USER_NAME);
				
		WebElement PasswordType= driver.findElement(By.id("user_pass"));
		PasswordType.sendKeys(Configuration.PASSWORD);
				
		WebElement SubmitButton= driver.findElement(By.id("wp-submit"));
		SubmitButton.click();
		
		// Click on first lesson
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ld-item-title"))).click();
		
		//Mark complete first lesson
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("learndash_mark_complete_button"))).click();
		
		//Verify second lesson
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ld-focus-content")));
		
		//Mark complete first lesson
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("learndash_mark_complete_button"))).click();
		
		//Verify course is complete
		WebElement Status= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'ld-status ld-status-complete ld-secondary-background')]")));
		System.out.println(Status.getText());
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
  
}
