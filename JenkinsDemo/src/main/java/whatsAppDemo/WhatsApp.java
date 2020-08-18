package whatsAppDemo;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WhatsApp {

	@Test
	public void watsApp() throws InterruptedException {

		// Here we need to create logger instance so we need to pass Class name for
		// which we want to create log file in my case Google is classname
		Logger logger = Logger.getLogger("WhatsApp");

		// configure log4j properties file
		PropertyConfigurator.configure("log4j.properties");

		// Open browser
		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		logger.info("Browser Opened");

		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Implicit wait given");

		// Load application
		driver.get("https://web.whatsapp.com/");
		logger.info("Url opened");

		Thread.sleep(2000);
		logger.info("Scanned QR code and then press Enter!");

		//Scanner sc = new Scanner(System.in);
		logger.info("Enter Any Number to Proceed");
		//int n = sc.nextInt();
		logger.info("Logged into the WatsAppWeb");
		WebElement input_xpath = driver.findElement(By.xpath("//div[contains(text(),'Search or start new chat')]"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", input_xpath);
		Thread.sleep(3000);
		WebElement select_contact = driver
				.findElement(By.xpath("//span[@class='_3ko75 _5h6Y_ _3Whw5'][contains(text(),'Vinay')]"));
		System.out.println("Finding Sunny!");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(select_contact).click(select_contact).perform();
		logger.info("Trying the reach out to contact Sunny!");
		WebElement input_message = driver.findElement(By.cssSelector("body.web:nth-child(2) div._347-w._2UMYL.app-wrapper-web.os-win div.h70RQ.two:nth-child(6) div._1-iDe.Wu52Z:nth-child(4) div._2WG1s footer._2vJ01:nth-child(7) div._3ee1T._1LkpH.copyable-area div._3uMse:nth-child(2) div._2FVVk._2UL8j > div._3FRCZ.copyable-text.selectable-text"));
		//WebDriverWait myDynamicElement = new WebDriverWait(driver, 30);
        //myDynamicElement.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_2FVVk _2UL8j']//div[@class='_3FRCZ copyable-text selectable-text']")));
		
		
		Thread.sleep(3000);
		logger.info("Trying to Send the message to Sunny!");
		input_message.sendKeys("Hi Sunny,i am selenium here send through Automation! Loving to work at ur service");
		input_message.sendKeys("\nHola!");
		Thread.sleep(3000);
		logger.info("Adding a Heart Smiley:");
		WebElement smileys = driver.findElement(By.xpath("//button[@class='FIHAk _3fM82 a37s7 _2Q56Q _2TkoI']//span"));
		smileys.click();
		WebElement smiley = driver.findElement(By.xpath("//span[@class='b7 emojik wa']"));
		smiley.click();
		input_message.sendKeys(Keys.ENTER);
		driver.quit();

	}
	
	
	
	
}
