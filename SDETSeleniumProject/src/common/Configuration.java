package common;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Configuration {
	
	public static String DRIVER_DIR= System.getProperty("user.dir")
			+File.separator
			+"drivers"
			+File.separator;
	
	//public static String CHROME_DRIVER_PATH= DRIVER_DIR + "chromedriver.exe";
	public static String GECKO_DRIVER_PATH= DRIVER_DIR + "geckodriver.exe";
	
	public static String JobBoard_Url= "https://alchemy.hguy.co/lms";
	
	public static String USER_NAME="root";
	public static String PASSWORD="pa$$w0rd";
	
	/*public static String SCREENSHOTS_DIR=System.getProperty("user.dir")
			+File.separator
			+"screenshots"
			+File.separator;	
	
	public static WebDriver createChromeDriver(ChromeOptions options) {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		return new ChromeDriver(options);
	}
	
	
	public static WebDriver createChromeDriver() {
		return  createChromeDriver(new ChromeOptions());
	}
	
	*/
		
	public static WebDriver createFireFoxDriver(FirefoxOptions options) {
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
		return new FirefoxDriver(options);
	}

	public static WebDriver createFireFoxDriver() {
		return createFireFoxDriver(new FirefoxOptions());

	}

}
