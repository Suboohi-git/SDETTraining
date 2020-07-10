package session10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Configuration;

public class Activity8_ContactAdmin {
	
private WebDriver driver = null;
private WebDriverWait wait= null;
	
	@BeforeTest
	public void BrowserLaunch() throws InterruptedException {
		
		driver= Configuration.createFireFoxDriver();
		wait= new WebDriverWait(driver, 60);
		driver.get(Configuration.JobBoard_Url);
		
	}
	
	@Test
	public void ContactAdmin() throws InterruptedException {
		
		WebElement GetLink= driver.findElement(By.partialLinkText("Contact"));
		GetLink.click();
		
		WebElement FirstName= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wpforms-8-field_0")));
		FirstName.sendKeys("Suboohi Shaheen");
		
		WebElement Email= driver.findElement(By.id("wpforms-8-field_1"));
		Email.sendKeys("abc@gmail.com");
		
		WebElement Subject= driver.findElement(By.id("wpforms-8-field_3"));
		Subject.sendKeys("This is a Selenium Project test");
		
		WebElement Comment= driver.findElement(By.id("wpforms-8-field_2"));
		Comment.sendKeys("This is a Project test");
		
		WebElement Submitbutton= driver.findElement(By.id("wpforms-submit-8"));
		Submitbutton.click();
		
		WebElement Confirmationmsg= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wpforms-confirmation-8")));
		String Msg= Confirmationmsg.getText();
		System.out.println("Confirmation msg is : " + Msg);
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
 
}
