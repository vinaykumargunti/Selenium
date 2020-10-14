package actionclass;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClick {
	
	@Test
	public void doubleclickbutton() {
	Logger logger = Logger.getLogger("Double Click properties");
	PropertyConfigurator.configure("log4j.properties");
	 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
     
     WebDriver driver=new ChromeDriver();
	logger.info("Driver intialized");
	driver.manage().window().maximize();
	driver.get("https://api.jquery.com/dblclick/");
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
	Actions act=new Actions(driver);
	
		
	
	act.doubleClick(driver.findElement(By.xpath("//span[contains(text(),'Double click the block')]//parent::body/div"))).perform();
	
	
	}
}
