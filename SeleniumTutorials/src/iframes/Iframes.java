package iframes;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
//You can give frame name or id or index or WebElement


public class Iframes {
	@Test
	public void iframeswitching() {
		
		Logger logger = Logger.getLogger("Switching Between Iframes");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		logger.info("Driver intialized");
		driver.get("file:///D:/Coding/SeleniumWork/Selenium/SeleniumTutorials/iframe.html");
		int totalframes=driver.findElements(By.tagName("iframe")).size();
		logger.info("finding the number of iframes in a webpage"+totalframes);
		driver.switchTo().frame("seleniumHQ");
		logger.info("switching to second frame of the webpage");
		driver.findElement(By.xpath("//div[@id='bottomnext']//a[@class='next'][contains(text(),'next')]")).click();
		logger.info("moving back to the default frame as we can't traverse between frames");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Click here')]")).click();
		logger.info("operating on the link after switching to the default frame");
		driver.quit();
	}

}
