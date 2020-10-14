package iframes;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RedBus {
	
	@Test
	public void travelapp() {
		Logger logger = Logger.getLogger("Switching Between Iframes");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		logger.info("Driver intialized");
		driver.get("https://www.redbus.com/");
		
		driver.findElement(By.xpath("//div[@id='sign-in-icon-down']")).click();
		driver.findElement(By.xpath("//li[@id='signInLink']")).click();

		WebElement modalframe=driver.findElement(By.xpath("//div[@class='modal']//iframe[@class='modalIframe']"));
		
		driver.switchTo().frame(modalframe);
		driver.findElement(By.xpath("//div[@class='mobileInput clearfix']//following::input[@id='mobileNoInp']")).sendKeys("8328379319");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='social-acc-box margin-g']")).click();
		
	}

}
