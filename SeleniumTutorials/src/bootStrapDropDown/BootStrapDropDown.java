package bootStrapDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BootStrapDropDown {
@Test
	public void main() {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("DropDownButton");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		logger.info("Driver intialized");
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		String Actual=driver.getTitle();
		String Expected="Selenium Practise: Bootstrap Dropdown Example for Selenium";
		//verifying the title of the page
		Assert.assertEquals(Actual, Expected);
		Assert.assertTrue(Actual.contains(Expected));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='menu1']")).click();
		List<WebElement> bootstrapdropdown=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
		for(WebElement ele:bootstrapdropdown) {
			
			String innerhtml=ele.getAttribute("innerHTML");
			if(innerhtml.contains("JavaScript"))
				ele.click();
			break;
			
		}
	}

}
