package wait;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ImplicitWait {
	
	
	@Test
	public void waitDemo() {
		
		Logger logger = Logger.getLogger("Switching Between Iframes");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		logger.info("Driver intialized");
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Vinaykumar Gunti");
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']"))));
		element.click();
		
		
	}

}
