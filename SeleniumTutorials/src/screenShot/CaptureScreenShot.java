package screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CaptureScreenShot {
	
	@Test
	public void CaptureScreenShotSaver() {
		Logger logger = Logger.getLogger("ScreenShot");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		logger.info("Driver intialized");
		driver.get("https://www.facebook.com/");
		Utility.captureScreenshot(driver, "OpeningWebpage");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("VinayKumar Gunti");	
		logger.info("Taking ScreenShot");
		Utility.captureScreenshot(driver, "WebElementCaptured");
		
	}

}
