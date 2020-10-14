package dragandDrop;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragandDropDemo2 {
	@Test
	public void webTableHandleDate() throws Exception {
	
			Logger logger = Logger.getLogger("Drag and Drop Demo");
			PropertyConfigurator.configure("log4j.properties");
			 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
		     
		     WebDriver driver=new ChromeDriver();
			logger.info("Driver intialized");
			driver.manage().window().maximize();
			
			driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
			
			Actions act=new Actions(driver);
			
			WebElement source=driver.findElement(By.xpath("//span[contains(text(),'Learning DHTMLX Suite UI')]"));
			WebElement target=driver.findElement(By.xpath("//*[text()='Zend Framework in Action']"));
			
		act.dragAndDrop(source, target).perform();
		

	}
}

