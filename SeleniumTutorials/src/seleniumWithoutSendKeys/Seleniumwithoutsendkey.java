package seleniumWithoutSendKeys;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Seleniumwithoutsendkey {
	
	
	@Test
	public void withoutSendKeys() {
	Logger logger = Logger.getLogger("Seleniumwithoutsendkeys");
	PropertyConfigurator.configure("log4j.properties");
	 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
     
     WebDriver driver=new ChromeDriver();
	logger.info("Driver intialized");
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	WebElement input=driver.findElement(By.xpath("//input[@aria-label='First name']"));
	jse.executeScript("arguments[0].value='vinay'", input);
	WebElement input2=driver.findElement(By.xpath("//input[@id='u_0_o']"));
	jse.executeScript("arguments[0].value=arguments[1]", input2,"gunti");
	
	WebElement radio=driver.findElement(By.xpath("//input[@id='u_0_6']"));
	jse.executeScript("arguments[0].click()", radio);
	
	

}
}
