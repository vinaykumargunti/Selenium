package webTableHandle;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WebTableHandleCalender {
	@Test
	public void webTableHandleDate() throws Exception {
		Logger logger = Logger.getLogger("WebTableHandle");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		logger.info("Driver intialized");
		driver.manage().window().maximize();

		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		List<WebElement> element = driver
				.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//table/tbody//td"));
		for (int i = 0; i < element.size(); i++) {

			String date = element.get(i).getText();

			if (date.equals("31")) {

				element.get(i).click();
				break;

			}

		}

	}
}
