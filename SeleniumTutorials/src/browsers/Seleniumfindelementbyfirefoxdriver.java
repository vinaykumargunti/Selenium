package browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//browser version-78.0.2 (64-bit)
//https://github.com/mozilla/geckodriver/releases-for firefox geckodriver geckodriver-v0.26.0-win32
//https://www.selenium.dev/downloads/-Download Latest stable version 3.141.59
//use chropath on right corner dropdown animation and copy real xpath. 
//WebDriver is a remote control interface that enables introspection and control of user agents.
//It provides a platform- and language-neutral wire protocol as a way for out-of-process programs to remotely instruct the behavior of web browsers.
//dl.bintray.com/testng-team/testng-eclipse-release/ -TestNG
public class Seleniumfindelementbyfirefoxdriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys("Vinay Kumar");
		driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys("Gunti");
		driver.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys("vinayjaan33@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("8125488313");
		driver.findElement(By.xpath("//input[@id='u_0_7']")).click();
		driver.findElement(By.xpath("//input[@id='u_0_u']")).sendKeys("vinayjaan33@gmail.com");
		Select sec1 = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		sec1.selectByValue("6");
		Select sec2 = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		sec2.selectByVisibleText("Sept");
		Select sec3 = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		sec3.selectByValue("2010");
		driver.findElement(By.xpath("//button[@id='u_0_12']")).click();
		driver.findElement(By.xpath("//a[@class='_8esh']")).click();
		driver.navigate().back();
		// driver.quit();

	}

}
