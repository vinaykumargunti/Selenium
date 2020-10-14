package actionclass;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyBoardEvents {
	@Test
	public void keyboardevent1() {
	Logger logger = Logger.getLogger("KeyBoardEvents");
	PropertyConfigurator.configure("log4j.properties");
	 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
     
     WebDriver driver=new ChromeDriver();
	logger.info("Driver intialized");
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	
	Actions act=new Actions(driver);
	driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("vinay");
	
  act.sendKeys(Keys.TAB)
  .pause(Duration.ofMillis(2000))
  .sendKeys("gunti")
  .sendKeys(Keys.TAB)
  .pause(Duration.ofSeconds(2))
  .sendKeys("8008958799")
  .sendKeys(Keys.TAB)
  .pause(Duration.ofSeconds(2))
  .sendKeys("vinay").perform();
  
}
}
