package session10;

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

public class Activity6_LoggingintoSite {
	
	private WebDriver driver = null;
	private WebDriverWait wait= null;
	
	@BeforeTest
	public void BrowserLaunch() throws InterruptedException {
		
		driver= Configuration.createFireFoxDriver();
		wait= new WebDriverWait(driver, 60);
		driver.get(Configuration.JobBoard_Url);
		
	}
	
	@Test
	public void LoginintoSite() throws InterruptedException {
		
		WebElement GetLink=wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("My Account")));
		GetLink.click();
		String NewPageTitle=driver.getTitle();
		System.out.println("New Page Title is : " + NewPageTitle);
		Assert.assertEquals(NewPageTitle, "My Account – Alchemy LMS");
		
		// Login into Account
		WebElement LoginButton= driver.findElement(By.partialLinkText("Login"));
		LoginButton.click();
		
		// Entering username and login
		
		WebElement UserNametype= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));
		UserNametype.sendKeys(Configuration.USER_NAME);
		
		WebElement PasswordType= driver.findElement(By.id("user_pass"));
		PasswordType.sendKeys(Configuration.PASSWORD);
		
		WebElement SubmitButton= driver.findElement(By.id("wp-submit"));
		SubmitButton.click();
		
		// Check the title
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("uagb-ifb-title")));
		String LoginPageTitle=driver.getTitle();
		System.out.println("New Page Title is : " + LoginPageTitle);
		Assert.assertEquals(LoginPageTitle, "My Account – Alchemy LMS");
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
  
  
}
