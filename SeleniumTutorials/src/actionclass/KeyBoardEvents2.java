package actionclass;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyBoardEvents2 {
	@Test
	public void keyboardevent1() {
	Logger logger = Logger.getLogger("KeyBoardEvents");
	PropertyConfigurator.configure("log4j.properties");
	 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
     
     WebDriver driver=new ChromeDriver();
	logger.info("Driver intialized");
	driver.manage().window().maximize();
	driver.get("https://the-internet.herokuapp.com/key_presses");
	
	Actions act=new Actions(driver);
	//driver.findElement(By.xpath("//input[@id='target']")).click();
	act.sendKeys(Keys.ENTER).build().perform();
	
	if(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("ENTER")){
		
		logger.info("value is ENTER");
	}
	
}

}