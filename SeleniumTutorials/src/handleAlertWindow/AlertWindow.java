package handleAlertWindow;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertWindow {
	@Test
	public void alertWindowTab() throws InterruptedException {
		Logger logger = Logger.getLogger("Alert Window");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		logger.info("Driver intialized");
		driver.get("https://ksrtc.in/oprs-web/");
		
		driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/div[1]/div[1]/div[2]/div[3]/button[1]")).click();
		String alertvalue=driver.switchTo().alert().getText();
		logger.info("Getting Alert Text Value");
		String ExpectedValue="Please select start place.";
		Assert.assertEquals(alertvalue, ExpectedValue);
		logger.info("Test Case Passed");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		logger.info("Accepting the Alert");
		
		
		
	}

}
