package dragandDrop;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DragandDropDemo3 {
	@Test
	public void webTableHandleDate() throws Exception {
	
			Logger logger = Logger.getLogger("Drag and Drop Demo");
			PropertyConfigurator.configure("log4j.properties");
			 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
		     
		     WebDriver driver=new ChromeDriver();
			logger.info("Driver intialized");
			driver.manage().window().maximize();
			
			driver.get("https://jqueryui.com/draggable/");
			
			Actions act=new Actions(driver);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
			
			WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", source);
			
			act.dragAndDropBy(source, 300, 150).perform();

		

	}
}

