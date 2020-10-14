package bootStrapPopUpWindow;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BootStrapPopUpWindow {
	@Test
	public void BootStrapPopWindow() throws InterruptedException {

		Logger logger = Logger.getLogger("HandleBootStrapWindowPopupindifferentFrame");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		logger.info("Driver intialized");
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//a[@id='get_sign_up']")).click();
		driver.switchTo().frame("authiframe");
		driver.findElement(By.xpath("//input[@id='authMobile']")).sendKeys("8328379319");
		Thread.sleep(3000);

		driver.findElement(By.id("mobileSubmitBtn")).click();
		// WebDriverWait wait=new WebDriverWait(driver,10);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mobileSubmitBtn\"]"))).click();
		// driver.quit();

	}

}
