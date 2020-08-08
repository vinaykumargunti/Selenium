package comm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test123 {

	WebDriver driver;
	
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Google"));
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("vinaykumar gunti");;
		driver.quit();
	}
}
