package windowAuthenticator;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandleWindowAuthenticator {
	@Test
	public void autoit() throws Exception {
	
			Logger logger = Logger.getLogger("Handling Windows Authentication using AUTOIT");
			PropertyConfigurator.configure("log4j.properties");
			System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			logger.info("Driver intialized");
			driver.manage().window().maximize();
			
			driver.get("https://www.engprod-charter.net/");
			
			Thread.sleep(3000);
			Runtime.getRuntime().exec("D:\\Coding\\Seleniumlib\\AutoIT\\FileScript1.exe");
			
			
}
}
