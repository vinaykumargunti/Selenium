package autoIT;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AutoITFileUpload {
	@Test
	public void autoit() throws Exception {
	
			Logger logger = Logger.getLogger("Uploading file using AUTOIT");
			PropertyConfigurator.configure("log4j.properties");
			System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			logger.info("Driver intialized");
			driver.manage().window().maximize();
			
			driver.get("file:///D://Coding//Seleniumlib//AutoIT//demo.html");
			WebElement ele=driver.findElement(By.xpath("//input[@id='1']"));
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);
			Thread.sleep(3000);
			Runtime.getRuntime().exec("D:\\Coding\\Seleniumlib\\AutoIT\\FileScript.exe");
			
			
}
}
