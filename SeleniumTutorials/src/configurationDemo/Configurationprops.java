package configurationDemo;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Configurationprops {
	
	WebDriver driver;
	Properties pro;
	@BeforeMethod
	public void intial() {
		 pro = Configgenerics.properties();
		String chromedriver = pro.getProperty("chromedriver");
		String chromedriverpath = pro.getProperty("chromedriverpath");
		System.setProperty(chromedriver, chromedriverpath);
		driver = new ChromeDriver();
		String URL = pro.getProperty("URL");
		driver.get(URL);
		
	}
	
	@Test
	public void propertyuse() {
		
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");

		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		driver.quit();
	}
	
	
	
	

}
